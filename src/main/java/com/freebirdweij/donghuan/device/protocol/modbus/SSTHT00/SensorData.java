package com.freebirdweij.donghuan.device.protocol.modbus.SSTHT00;


public class SensorData {
    private double temperature;
    private double humidity;
    private Double dewPoint; // Nullable, as it might not always be present

    public SensorData(double temperature, double humidity, Double dewPoint) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.dewPoint = dewPoint;
    }

    // Getters and setters

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public Double getDewPoint() {
        return dewPoint;
    }

    @Override
    public String toString() {
        return "SensorData{" +
               "temperature=" + temperature +
               ", humidity=" + humidity +
               ", dewPoint=" + dewPoint +
               '}';
    }
}