package com.freebirdweij.donghuan.device.data.base;

public abstract class SwitchingPowerSupply extends Device {
    private double inputVoltage;
    private double outputVoltage;
    private double outputCurrent;
    private double loadPercentage;

    public SwitchingPowerSupply(String deviceId, String deviceName, DeviceLocation location, String status,
                                double inputVoltage, double outputVoltage, double outputCurrent, double loadPercentage) {
        super(deviceId, deviceName, "Switching Power Supply", location, status);
        this.inputVoltage = inputVoltage;
        this.outputVoltage = outputVoltage;
        this.outputCurrent = outputCurrent;
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

    public double getOutputCurrent() {
        return outputCurrent;
    }

    public void setOutputCurrent(double outputCurrent) {
        this.outputCurrent = outputCurrent;
    }

    public double getLoadPercentage() {
        return loadPercentage;
    }

    public void setLoadPercentage(double loadPercentage) {
        this.loadPercentage = loadPercentage;
    }
}

