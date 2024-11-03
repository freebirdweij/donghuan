package com.freebirdweij.donghuan.device.data;
// 温湿度传感器类
public class TemperatureHumiditySensor extends Device {
    private double temperature;
    private double humidity;

    // 构造方法
    public TemperatureHumiditySensor(String deviceId, String deviceName, String location, String status,
                                     double temperature, double humidity) {
        super(deviceId, deviceName, "Temperature & Humidity Sensor", location, status);
        this.temperature = temperature;
        this.humidity = humidity;
    }

    // 温湿度传感器独有的方法
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

    @Override
    public void monitor() {
        System.out.println("Monitoring Temperature & Humidity Sensor: " + getDeviceName());
        System.out.println("Temperature: " + temperature + "°C");
        System.out.println("Humidity: " + humidity + "%");
    }

    @Override
    public Object getData() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getData'");
    }
}

