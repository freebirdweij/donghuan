package com.freebirdweij.donghuan.device.data.base;

/**
 * SmokeDetector 类表示烟雾探测器设备。
 */
public class SmokeDetector extends Device {
    private boolean smokeDetected; // 是否检测到烟雾
    private double smokeLevel;     // 烟雾浓度

    /**
     * 构造方法，初始化烟雾探测器。
     * @param deviceId 设备 ID
     * @param deviceName 设备名称
     * @param location 设备位置
     * @param status 设备状态
     * @param smokeDetected 是否检测到烟雾
     * @param smokeLevel 烟雾浓度
     */
    public SmokeDetector(String deviceId, String deviceName, DeviceLocation location, String status, boolean smokeDetected, double smokeLevel) {
        super(deviceId, deviceName, "Smoke Detector", location, status);
        this.smokeDetected = smokeDetected;
        this.smokeLevel = smokeLevel;
    }

    /**
     * 获取烟雾探测器数据。
     * @return 烟雾探测器数据
     */
    public String getData() {
        return "Smoke Detected: " + (smokeDetected ? "Yes" : "No") + ", Smoke Level: " + smokeLevel;
    }

    /**
     * 监控烟雾探测器。
     */
    @Override
    public void monitor() {
        System.out.println("Monitoring Smoke Detector: " + getDeviceName());
        System.out.println("Smoke Detected: " + (smokeDetected ? "Yes" : "No"));
        System.out.println("Smoke Level: " + smokeLevel);
    }

    // 其他方法
    public boolean isSmokeDetected() {
        return smokeDetected;
    }

    public void setSmokeDetected(boolean smokeDetected) {
        this.smokeDetected = smokeDetected;
    }

    public double getSmokeLevel() {
        return smokeLevel;
    }

    public void setSmokeLevel(double smokeLevel) {
        this.smokeLevel = smokeLevel;
    }
}
