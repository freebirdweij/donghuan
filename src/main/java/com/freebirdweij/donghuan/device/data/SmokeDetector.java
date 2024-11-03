package com.freebirdweij.donghuan.device.data;
//烟雾报警器用于探测烟雾，预防火灾。
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
    public SmokeDetector(String deviceId, String deviceName, String location, String status, boolean smokeDetected, double smokeLevel) {
        super(deviceId, deviceName, "Smoke Detector", location, status);
        this.smokeDetected = smokeDetected;
        this.smokeLevel = smokeLevel;
    }

    /**
     * 获取烟雾探测器数据。
     * @return 烟雾探测器数据
     */
    @Override
    public String getData() {
        return "Smoke Detected: " + (smokeDetected ? "Yes" : "No") + ", Smoke Level: " + smokeLevel;
    }

    // 烟雾探测器独有的方法

    public boolean isSmokeDetected() {
        return smokeDetected; // 返回是否检测到烟雾
    }

    public void setSmokeDetected(boolean smokeDetected) {
        this.smokeDetected = smokeDetected; // 设置是否检测到烟雾
    }

    public double getSmokeLevel() {
        return smokeLevel; // 返回烟雾浓度
    }

    public void setSmokeLevel(double smokeLevel) {
        this.smokeLevel = smokeLevel; // 设置烟雾浓度
    }

    /**
     * 监控烟雾探测器。
     */
    @Override
    public void monitor() {
        // 使用日志记录框架替代 System.out.println
        System.out.println("Monitoring Smoke Detector: " + getDeviceName());
        System.out.println("Smoke Detected: " + (smokeDetected ? "Yes" : "No"));
        System.out.println("Smoke Level: " + smokeLevel);
    }
}
