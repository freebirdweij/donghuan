package com.freebirdweij.donghuan.device.data.base;

public abstract class Device {
    private String deviceId;
    private String deviceName;
    private String deviceType;
    private String deviceModel;
    private Float deviceCosts;
    private String manufacturer;
    private DeviceLocation location;
    private DevicePosition position;
    private String status;
    private String remarks;


    // 构造方法
    public Device(String deviceId, String deviceName, String deviceType, DeviceLocation location, String status) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.deviceType = deviceType;
        this.location = location;
        this.status = status;
    }

    public Device(String deviceId, String deviceName, String deviceType, String deviceModel, 
                 Float deviceCosts, DeviceLocation location, String status, String remarks) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.deviceType = deviceType;
        this.deviceModel = deviceModel;
        this.deviceCosts = deviceCosts;
        this.location = location;
        this.status = status;
        this.remarks = remarks;
    }    // Methods to get and set the properties


    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Float getDeviceCosts() {
        return deviceCosts;
    }

    public void setDeviceCosts(Float deviceCosts) {
        this.deviceCosts = deviceCosts;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    // 抽象的监控方法
    public abstract void monitor();

    // 公共方法
    public String getDeviceId() {
        return deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public DeviceLocation getLocation() {
        return location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public DevicePosition getPosition() {
        return position;
    }

    public void setPosition(DevicePosition position) {
        this.position = position;
    }
}
