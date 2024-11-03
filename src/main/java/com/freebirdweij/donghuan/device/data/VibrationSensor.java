package com.freebirdweij.donghuan.device.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * VibrationSensor 类表示振动传感器设备。
 */
public class VibrationSensor extends Device {
    private static final Logger logger = LoggerFactory.getLogger(VibrationSensor.class);
    private double vibrationLevel;

    public VibrationSensor(String id, String name, String location, String status, double vibrationLevel) {
        super(id, name, "Vibration Sensor", location, status);
        this.vibrationLevel = vibrationLevel;
    }

    @Override
    public Object getData() {
        return vibrationLevel;
    }

    @Override
    public void monitor() {
        logger.info("Monitoring Vibration Sensor: {}", getName());
        logger.info("Current Vibration Level: {}", vibrationLevel);
    }
}
