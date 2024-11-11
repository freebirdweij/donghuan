package com.freebirdweij.donghuan.device.data.base;

public abstract class Generator extends Device {
    private double fuelLevel;
    private double powerOutput;
    private boolean isRunning;

    public Generator(String deviceId, String deviceName, DeviceLocation location, String status,
                     double fuelLevel, double powerOutput, boolean isRunning, String deviceModel) {
                             super(deviceId, deviceName, "Generator", deviceModel, location, status);
        this.fuelLevel = fuelLevel;
        this.powerOutput = powerOutput;
        this.isRunning = isRunning;
    }

    // 抽象类的 monitor() 方法
    public abstract void monitor();

    // 其他方法
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
}

