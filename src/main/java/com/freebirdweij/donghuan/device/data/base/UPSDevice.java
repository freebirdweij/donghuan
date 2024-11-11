package com.freebirdweij.donghuan.device.data.base;

public abstract class UPSDevice extends Device {
    private double inputVoltage;
    private double outputVoltage;
    private double batteryLevel;
    private double loadPercentage;

    public UPSDevice(String deviceId, String deviceName, DeviceLocation location, String status, 
                     double inputVoltage, double outputVoltage, double batteryLevel, double loadPercentage, String deviceModel) {
                             super(deviceId, deviceName, "UPS", deviceModel, location, status);
        this.inputVoltage = inputVoltage;
        this.outputVoltage = outputVoltage;
        this.batteryLevel = batteryLevel;
        this.loadPercentage = loadPercentage;
    }

    // 抽象类的 monitor() 方法
    public abstract void monitor();

    // 其他方法
    public double getInputVoltage() {
        return inputVoltage;
    }

    public void setInputVoltage(double inputVoltage) {
        this.inputVoltage = inputVoltage;
    }

    public double getOutputVoltage() {
        return outputVoltage;
    }

    public void setOutputVoltage(double outputVoltage) {
        this.outputVoltage = outputVoltage;
    }

    public double getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(double batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public double getLoadPercentage() {
        return loadPercentage;
    }

    public void setLoadPercentage(double loadPercentage) {
        this.loadPercentage = loadPercentage;
    }
}

