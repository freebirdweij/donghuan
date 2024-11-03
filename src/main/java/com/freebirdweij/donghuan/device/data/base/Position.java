package com.freebirdweij.donghuan.device.data.base;
//位置抽象类
public abstract class Position {
    private double latitude; // 纬度
    private double longitude; // 经度
    private double height; // 高度
    private String referencePoint; // 参考点（如与其他设备的相对位置）
    // ... existing fields ...
    
    // 构造函数
    public Position() {
    }

    public Position(double latitude, double longitude, double height, String referencePoint) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.height = height;
        this.referencePoint = referencePoint;
    }

    // Getter和Setter方法
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getReferencePoint() {
        return referencePoint;
    }

    public void setReferencePoint(String referencePoint) {
        this.referencePoint = referencePoint;
    }
}
