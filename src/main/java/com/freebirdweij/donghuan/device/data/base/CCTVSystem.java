package com.freebirdweij.donghuan.device.data.base;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * CCTVSystem 类表示视频监控系统。
 */
public class CCTVSystem extends Device {
    private static final Logger logger = LoggerFactory.getLogger(CCTVSystem.class);
    private boolean recording; // 是否正在录制
    private LocalDateTime lastRecordingTime; // 上次录制时间

    /**
     * 构造方法，初始化视频监控系统。
     * @param id 设备 ID
     * @param name 设备名称
     * @param location 设备位置
     * @param status 设备状态
     * @param recording 是否正在录制
     * @param lastRecordingTime 上次录制时间
     * @param deviceModel 
     */
    public CCTVSystem(String id, String name, DeviceLocation location, String status, boolean recording, String lastRecordingTime, String deviceModel) {
             super(id, name, "CCTV System", deviceModel, location, status);
        this.recording = recording;
        this.lastRecordingTime = LocalDateTime.parse(lastRecordingTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    /**
     * 获取视频监控系统数据。
     * @return 视频监控系统数据
     */
    public Map<String, Object> getData() {
        return Map.of(
            "recording", recording,
            "lastRecordingTime", lastRecordingTime
        );
    }

    /**
     * 监控视频监控系统。
     */
    @Override
    public void monitor() {
        logger.info("Monitoring CCTV System: {}", getDeviceName());
        logger.info("Is Recording: {}", recording ? "Yes" : "No");
        logger.info("Last Recorded Time: {}", lastRecordingTime);
    }
}
