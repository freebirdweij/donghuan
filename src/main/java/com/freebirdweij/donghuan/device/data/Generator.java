package com.freebirdweij.donghuan.device.data;
//发电机通常用于提供备用电源。我们可以监控其燃料水平、功率输出、运行状态等。
public class Generator extends Device {
    private double fuelLevel;
    private double powerOutput;
    private boolean isRunning;

    @Override
    public String getData() {
        return "Fuel Level: " + fuelLevel + "%, Power Output: " + powerOutput + "kW, Is Running: " + (isRunning ? "Yes" : "No");
    }

    // 构造方法
    public Generator(String deviceId, String deviceName, String location, String status,
                     double fuelLevel, double powerOutput, boolean isRunning) {
        super(deviceId, deviceName, "Generator", location, status);
        this.fuelLevel = fuelLevel;
        this.powerOutput = powerOutput;
        this.isRunning = isRunning;
    }

    // 发电机设备独有的方法
    public double getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public double getPowerOutput() {
        return powerOutput;
    }

    public void setPowerOutput(double powerOutput) {
        this.powerOutput = powerOutput;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    @Override
    public void monitor() {
        System.out.println("Monitoring Generator: " + getDeviceName());
        System.out.println("Fuel Level: " + fuelLevel + "%");
        System.out.println("Power Output: " + powerOutput + "kW");
        System.out.println("Is Running: " + (isRunning ? "Yes" : "No"));
    }
}

