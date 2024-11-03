package com.freebirdweij.donghuan.device.data;
//空调设备类
public class AirConditionerDevice extends Device {
    private double currentTemperature;
    private double setTemperature;
    private boolean isOn;
    @Override
    public String getData() {
        return "Current Temperature: " + currentTemperature + "°C, Set Temperature: " + setTemperature + "°C, Is On: " + (isOn ? "Yes" : "No");
    }
    // 构造方法
    public AirConditionerDevice(String deviceId, String deviceName, String location, String status,
                                double currentTemperature, double setTemperature, boolean isOn) {
        super(deviceId, deviceName, "Air Conditioner", location, status);
        this.currentTemperature = currentTemperature;
        this.setTemperature = setTemperature;
        this.isOn = isOn;
    }

    // 空调设备独有的方法
    public double getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public double getSetTemperature() {
        return setTemperature;
    }

    public void setSetTemperature(double setTemperature) {
        this.setTemperature = setTemperature;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    @Override
    public void monitor() {
        System.out.println("Monitoring Air Conditioner Device: " + getDeviceName());
        System.out.println("Current Temperature: " + currentTemperature + "°C");
        System.out.println("Set Temperature: " + setTemperature + "°C");
        System.out.println("Is On: " + (isOn ? "Yes" : "No"));
    }
}

