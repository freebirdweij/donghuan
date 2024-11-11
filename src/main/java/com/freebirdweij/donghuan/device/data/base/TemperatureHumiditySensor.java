package com.freebirdweij.donghuan.device.data.base;

public abstract class TemperatureHumiditySensor extends Device {
    private double temperature;
    private double humidity;

    public TemperatureHumiditySensor(String deviceId, String deviceName, DeviceLocation location, String status, 
                                     double temperature, double humidity, String deviceModel) {
                                             super(deviceId, deviceName, "Temperature & Humidity Sensor", deviceModel, location, status);
        this.temperature = temperature;
        this.humidity = humidity;
    }

    // 抽象类的 monitor() 方法
    public abstract void monitor();

    // 其他方法
    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }
}
