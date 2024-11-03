package com.freebirdweij.donghuan.device.data.base;

import java.time.LocalDateTime;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AccessControlSystem 类表示门禁系统。
 */
public class AccessControlSystem extends Device {
    private static final Logger logger = LoggerFactory.getLogger(AccessControlSystem.class);
    private boolean accessGranted; // 是否授予访问权限
    private LocalDateTime lastAccessTime; // 上次访问时间
    private String lastAccessPerson; // 上次访问人员

    /**
     * 构造方法，初始化门禁系统。
     * @param id 设备 ID
     * @param name 设备名称
     * @param location 设备位置
     * @param status 设备状态
     * @param accessGranted 是否授予访问权限
     * @param lastAccessTime 上次访问时间
     * @param lastAccessPerson 上次访问人员
     */
    public AccessControlSystem(String id, String name, DeviceLocation location, String status, boolean accessGranted, LocalDateTime lastAccessTime, String lastAccessPerson) {
        super(id, name, "Access Control System", location, status);
        this.accessGranted = accessGranted;
        this.lastAccessTime = lastAccessTime;
        this.lastAccessPerson = lastAccessPerson;
    }

    /**
     * 获取门禁系统数据。
     * @return 门禁系统数据
     */
    public Map<String, Object> getData() {
        return Map.of(
            "accessGranted", accessGranted,
            "lastAccessTime", lastAccessTime,
            "lastAccessPerson", lastAccessPerson
        );
    }

    /**
     * 监控门禁系统。
     */
    @Override
    public void monitor() {
        logger.info("Monitoring Access Control System: {}", getDeviceName());
        logger.info("Access Granted: {}", accessGranted ? "Yes" : "No");
        logger.info("Last Access Time: {}", lastAccessTime);
        logger.info("Last Access Person: {}", lastAccessPerson);
    }
}
