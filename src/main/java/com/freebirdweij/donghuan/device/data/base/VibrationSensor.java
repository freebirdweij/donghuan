package com.freebirdweij.donghuan.device.data.base;

public abstract class VibrationSensor extends Device {
    private double vibrationLevel;

    public VibrationSensor(String deviceId, String deviceName, DeviceLocation location, String status, double vibrationLevel, String deviceModel) {
            super(deviceId, deviceName, "Vibration Sensor", deviceModel, location, status);
        this.vibrationLevel = vibrationLevel;
    }

    // 抽象类的 monitor() 方法
    public abstract void monitor();

    // 其他方法
    public double getVibrationLevel() {
        return vibrationLevel;
    }

    public void setVibrationLevel(double vibrationLevel) {
        this.vibrationLevel = vibrationLevel;
    }
}
