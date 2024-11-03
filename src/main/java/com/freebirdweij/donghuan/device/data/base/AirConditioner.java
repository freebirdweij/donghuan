package com.freebirdweij.donghuan.device.data.base;

public abstract class AirConditioner extends Device {
    private double setTemperature;
    private double currentTemperature;
    private String mode;  // 例如：制冷、制热、除湿、送风等模式
    private boolean isRunning;

    public AirConditioner(String deviceId, String deviceName, DeviceLocation location, String status, 
                          double setTemperature, double currentTemperature, String mode, boolean isRunning) {
        super(deviceId, deviceName, "Air Conditioner", location, status);
        this.setTemperature = setTemperature;
        this.currentTemperature = currentTemperature;
        this.mode = mode;
        this.isRunning = isRunning;
    }

    // 抽象类的 monitor() 方法
    public abstract void monitor();

    // 其他方法
    public double getSetTemperature() {
        return setTemperature;
    }

    public void setSetTemperature(double setTemperature) {
        this.setTemperature = setTemperature;
    }

    public double getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }
}
