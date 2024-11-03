package com.freebirdweij.donghuan.device.data.base;

public abstract class WaterLeakSensor extends Device {
    private boolean isLeakDetected;

    public WaterLeakSensor(String deviceId, String deviceName, DeviceLocation location, String status, boolean isLeakDetected) {
        super(deviceId, deviceName, "Water Leak Sensor", location, status);
        this.isLeakDetected = isLeakDetected;
    }

    // 抽象类的 monitor() 方法
    public abstract void monitor();

    // 其他方法
    public boolean isLeakDetected() {
        return isLeakDetected;
    }

    public void setLeakDetected(boolean isLeakDetected) {
        this.isLeakDetected = isLeakDetected;
    }
}

