package com.freebirdweij.donghuan.device.checkpoint.humiture;

public abstract class Humiture {
    private double temperature;
    private double humidity;
    private Double dewPoint; // Nullable, as it might not always be present

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

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public void setDewPoint(Double dewPoint) {
        this.dewPoint = dewPoint;
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
