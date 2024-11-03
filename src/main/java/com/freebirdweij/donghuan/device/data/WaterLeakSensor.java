package com.freebirdweij.donghuan.device.data;

/**
 * 漏水检测系统用于检测是否有水浸入机房或其他敏感区域。
 */
public class WaterLeakSensor extends Device {
    private boolean isLeakDetected;

    /**
     * 构造方法，初始化漏水传感器。
     * @param deviceId 设备 ID
     * @param deviceName 设备名称
     * @param location 设备位置
     * @param status 设备状态
     * @param isLeakDetected 是否检测到漏水
     */
    public WaterLeakSensor(String deviceId, String deviceName, String location, String status, boolean isLeakDetected) {
        super(deviceId, deviceName, "Water Leak Sensor", location, status);
        this.isLeakDetected = isLeakDetected;
    }

    /**
     * 获取传感器数据。
     * @return 漏水检测状态
     */
    @Override
    public String getData() {
        return "Leak Detected: " + (isLeakDetected ? "Yes" : "No");
    }

    /**
     * 检查是否检测到漏水。
     * @return 是否检测到漏水
     */
    public boolean isLeakDetected() {
        return isLeakDetected;
    }

    /**
     * 设置漏水检测状态。
     * @param isLeakDetected 是否检测到漏水
     */
    public void setLeakDetected(boolean isLeakDetected) {
        this.isLeakDetected = isLeakDetected;
    }

    /**
     * 监控漏水传感器。
     */
    @Override
    public void monitor() {
        System.out.println("Monitoring Water Leak Sensor: " + getDeviceName());
        System.out.println("Leak Detected: " + (isLeakDetected ? "Yes" : "No"));
    }
}
