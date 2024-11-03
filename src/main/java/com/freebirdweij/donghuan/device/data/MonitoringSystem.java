package com.freebirdweij.donghuan.device.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * MonitoringSystem 类用于监控设备的运行状态。
 */
public class MonitoringSystem {
    private static final Logger logger = LoggerFactory.getLogger(MonitoringSystem.class);

    /**
     * 主方法，启动设备监控。
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        try {
            // 实例化设备
            UPSDevice ups = new UPSDevice("UPS001", "Main UPS", "Room 1", "active", 220.0, 230.0, 80.5, 75.0);
            // 其他设备实例化...

            // 监控设备
            logger.info("Starting device monitoring...");
            ups.monitor();
            // 其他设备监控...

            logger.info("Device monitoring completed successfully");
        } catch (Exception e) {
            logger.error("Error during monitoring: ", e);
        }
    }
}
