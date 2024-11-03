package com.freebirdweij.donghuan.device.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Device 抽象类表示一个通用设备。
 * 提供了设备的基本属性和方法。
 */
public abstract class Device {
    protected static final Logger logger = LoggerFactory.getLogger(Device.class);
    
    protected String id;
    protected String name;
    protected String type;
    protected String location;
    protected String status;

    public Device(String id, String name, String type, String location, String status) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.location = location;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }

    public String getStatus() {
        return status;
    }

    public abstract Object getData();
    public abstract void monitor();

    public void activate() {
        this.status = "active";
    }

    public void deactivate() {
        this.status = "inactive";
    }

    public String getDeviceName() {
        return name;
    }
}
