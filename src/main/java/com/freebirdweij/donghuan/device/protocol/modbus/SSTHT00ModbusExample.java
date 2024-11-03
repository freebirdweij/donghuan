package com.freebirdweij.donghuan.device.protocol.modbus;

public class SSTHT00ModbusExample {
    public static void main(String[] args) {
        try {
            SSTHT00ModbusRTU modbus = new SSTHT00ModbusRTU("COM3", 9600, 8, 1, 0, 1);
            modbus.open();

            // 读取所有数据
            SSTHT00ModbusRTU.Data data = modbus.readAllData();
            System.out.println("All Data: " + data);

            // 读取温度
            double temperature = modbus.readTemperature();
            System.out.println("Temperature: " + temperature + " °C");

            // 读取湿度
            double humidity = modbus.readHumidity();
            System.out.println("Humidity: " + humidity + " %");

            // 读取露点
            Double dewPoint = modbus.readDewPoint();
            if (dewPoint != null) {
                System.out.println("Dew Point: " + dewPoint + " °C");
            } else {
                System.out.println("Dew Point data not available.");
            }

            modbus.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}