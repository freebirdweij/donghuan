package com.freebirdweij.donghuan.device.protocol.modbus.SSTHT00;


import com.freebirdweij.donghuan.device.protocol.modbus.SSTHT00.ModbusException;
import com.freebirdweij.donghuan.device.protocol.modbus.SSTHT00.SensorData;
import com.freebirdweij.donghuan.device.protocol.modbus.SSTHT00.CRC16;
import com.fazecast.jSerialComm.SerialPort;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class ModbusClient implements AutoCloseable {
    private SerialPort serialPort;
    private int deviceAddress;

    public ModbusClient(String portName, int baudRate, int deviceAddress) throws ModbusException {
        this.deviceAddress = deviceAddress;
        serialPort = SerialPort.getCommPort(portName);
        serialPort.setComPortParameters(baudRate, 8, SerialPort.ONE_STOP_BIT, SerialPort.NO_PARITY);
        serialPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 1000, 0);

        if (!serialPort.openPort()) {
            throw new ModbusException("Failed to open serial port: " + portName);
        }
    }

    @Override
    public void close() {
        if (serialPort != null && serialPort.isOpen()) {
            serialPort.closePort();
        }
    }

    public SensorData readAllData() throws ModbusException {
        byte functionCode = 0x04;
        int startAddress = 0x0000;
        int quantity = 0x0002; // Temperature and Humidity

        byte[] request = buildRequest(functionCode, startAddress, quantity);
        byte[] response = sendRequest(request);

        // Parse response
        if (response.length < 9) {
            throw new ModbusException("Incomplete response received.");
        }

        byte receivedFunction = response[1];
        if (receivedFunction != functionCode) {
            throw new ModbusException("Unexpected function code in response.");
        }

        int byteCount = response[2] & 0xFF;
        if (byteCount < 4) { // Minimum bytes for temperature and humidity
            throw new ModbusException("Invalid byte count in response.");
        }

        // Extract temperature
        int tempHigh = response[3] & 0xFF;
        int tempLow = response[4] & 0xFF;
        double temperature = parseData(tempHigh, tempLow);

        // Extract humidity
        int humHigh = response[5] & 0xFF;
        int humLow = response[6] & 0xFF;
        double humidity = parseData(humHigh, humLow);

        // Check if dew point is available
        Double dewPoint = null;
        if (byteCount >= 6) {
            int dewHigh = response[7] & 0xFF;
            int dewLow = response[8] & 0xFF;
            dewPoint = parseData(dewHigh, dewLow);
        }

        return new SensorData(temperature, humidity, dewPoint);
    }

    private double parseData(int high, int low) {
        int raw = (high << 8) | low;
        // Convert to signed integer
        if (raw > 32767) {
            raw -= 65536;
        }
        return raw / 10.0;
    }

    private byte[] buildRequest(byte functionCode, int startAddress, int quantity) {
        byte[] request = new byte[8];
        request[0] = (byte) deviceAddress;
        request[1] = functionCode;
        request[2] = (byte) (startAddress >> 8);
        request[3] = (byte) (startAddress & 0xFF);
        request[4] = (byte) (quantity >> 8);
        request[5] = (byte) (quantity & 0xFF);
        int crc = CRC16.calculateCRC(request, 6);
        request[6] = (byte) (crc & 0xFF);
        request[7] = (byte) ((crc >> 8) & 0xFF);
        return request;
    }

    private byte[] sendRequest(byte[] request) throws ModbusException {
        try {
            OutputStream os = serialPort.getOutputStream();
            InputStream is = serialPort.getInputStream();

            os.write(request);
            os.flush();

            // Read response
            byte[] buffer = new byte[256];
            int len = is.read(buffer);
            if (len == -1) {
                throw new ModbusException("No response received.");
            }

            return Arrays.copyOf(buffer, len);
        } catch (IOException e) {
            throw new ModbusException("IO Exception during communication.", e);
        }
    }

    public double readTemperature() throws ModbusException {
        byte functionCode = 0x04;
        int startAddress = 0x0000;
        int quantity = 0x0001; // Read 1 analog data (Temperature)

        byte[] request = buildRequest(functionCode, startAddress, quantity);
        byte[] response = sendRequest(request);

        // Parse response
        if (response.length < 7) {
            throw new ModbusException("Incomplete response received.");
        }

        byte receivedFunction = response[1];
        if (receivedFunction != functionCode) {
            throw new ModbusException("Unexpected function code in response.");
        }

        // Extract temperature
        int tempHigh = response[3] & 0xFF;
        int tempLow = response[4] & 0xFF;
        return parseData(tempHigh, tempLow);
    }

    public double readHumidity() throws ModbusException {
        byte functionCode = 0x04;
        int startAddress = 0x0001;
        int quantity = 0x0001; // Read 1 analog data (Humidity)

        byte[] request = buildRequest(functionCode, startAddress, quantity);
        byte[] response = sendRequest(request);

        // Parse response
        if (response.length < 7) {
            throw new ModbusException("Incomplete response received.");
        }

        byte receivedFunction = response[1];
        if (receivedFunction != functionCode) {
            throw new ModbusException("Unexpected function code in response.");
        }

        // Extract humidity
        int humHigh = response[3] & 0xFF;
        int humLow = response[4] & 0xFF;
        return parseData(humHigh, humLow);
    }

    public double readDewPoint() throws ModbusException {
        byte functionCode = 0x04;
        int startAddress = 0x0030;
        int quantity = 0x0001; // Read 1 analog data (Dew Point)

        byte[] request = buildRequest(functionCode, startAddress, quantity);
        byte[] response = sendRequest(request);

        // Parse response
        if (response.length < 7) {
            throw new ModbusException("Incomplete response received.");
        }

        byte receivedFunction = response[1];
        if (receivedFunction != functionCode) {
            throw new ModbusException("Unexpected function code in response.");
        }

        // Extract dew point
        int dewHigh = response[3] & 0xFF;
        int dewLow = response[4] & 0xFF;
        return parseData(dewHigh, dewLow);
    }

    private void verifyCRC(byte[] response, int length) throws ModbusException {
        if (length < 4) {
            throw new ModbusException("Response too short to contain CRC.");
        }

        int receivedCrc = ((response[length - 1] & 0xFF) << 8) | (response[length - 2] & 0xFF);
        int calculatedCrc = CRC16.calculateCRC(response, length - 2);

        if (receivedCrc != calculatedCrc) {
            throw new ModbusException("CRC mismatch. Received: " + receivedCrc + ", Calculated: " + calculatedCrc);
        }
    }

    // Additional methods for other commands can be implemented similarly
}