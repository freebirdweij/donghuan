package com.freebirdweij.donghuan.device.protocol.modbus.SSTHT00;


import com.freebirdweij.donghuan.device.protocol.modbus.SSTHT00.ModbusException;
import com.freebirdweij.donghuan.device.protocol.modbus.SSTHT00.SensorData;

public class Main {
    public static void main(String[] args) {
        String portName = "COM3"; // Replace with your serial port
        int baudRate = 9600;
        int deviceAddress = 0x01; // As per protocol example

        try (ModbusClient client = new ModbusClient(portName, baudRate, deviceAddress)) {
            SensorData data = client.readAllData();
            System.out.println(data);
        } catch (ModbusException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}