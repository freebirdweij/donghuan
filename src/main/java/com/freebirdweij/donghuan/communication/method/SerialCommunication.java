package com.freebirdweij.donghuan.communication.method;

import com.fazecast.jSerialComm.SerialPort;

/**
 * SerialCommunication 类用于处理串行通信。
 * 实现 CommunicationByte 接口以支持字节级通信。
 */
public class SerialCommunication extends CommunicationMethod {
    private SerialPort serialPort;
    private String portName;
    private int baudRate;

    public SerialCommunication(String portName, int baudRate) {
        this.portName = portName;   
        this.baudRate = baudRate;
    }

    @Override
    public boolean connect() {
        try {
            serialPort = SerialPort.getCommPort(portName);
            serialPort.setBaudRate(baudRate);
            if (!serialPort.openPort()) {
                throw new RuntimeException("Failed to open port: " + portName);
            }
        } catch (Exception e) {
            handleError("Failed to connect to port: " + portName, e);
        }
        return isConnected;
    }

    @Override
    public boolean disconnect() {
        if (serialPort != null && serialPort.isOpen()) {
            try {
                serialPort.closePort();
            } catch (Exception e) {
                handleError("Failed to disconnect from port: " + portName, e);
            } finally {
                serialPort = null; // Ensure the resource is released
            }
        }
        return isConnected;
    }


    private void handleError(String message, Exception e) {
        System.err.println(message + ": " + e.getMessage());
        e.printStackTrace(); // Print stack trace for debugging
    }

    @Override
    protected boolean init() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'init'");
    }
}
