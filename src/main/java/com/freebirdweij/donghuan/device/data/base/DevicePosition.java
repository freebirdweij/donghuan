package com.freebirdweij.donghuan.device.data.base;
//设备位置抽象类
public abstract class DevicePosition extends Position {

    // 机房相关属性
    private String serverArea;     // 机房区域
    private int rowNumber;         // 第几行
    private int columnNumber;      // 第几列
    private String cabinetNo;      // 机柜编号
    private int cabinetPosition;   // 机柜上的位置（U位）

    // 修改构造函数，添加新的参数
    public DevicePosition(String name, String description, String country, String province, 
                   String city, String district, String street, String streetNo,
                   String serverArea, int rowNumber, int columnNumber, 
                   String cabinetNo, int cabinetPosition) {
        // ... existing constructor assignments ...
        this.serverArea = serverArea;
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
        this.cabinetNo = cabinetNo;
        this.cabinetPosition = cabinetPosition;
    }

    // 为新属性添加 getter 方法
    public String getServerArea() {
        return serverArea;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public String getCabinetNo() {
        return cabinetNo;
    }

    public int getCabinetPosition() {
        return cabinetPosition;
    }

    // 为新属性添加 setter 方法
    public void setServerArea(String serverArea) {
        this.serverArea = serverArea;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }

    public void setCabinetNo(String cabinetNo) {
        this.cabinetNo = cabinetNo;
    }

    public void setCabinetPosition(int cabinetPosition) {
        this.cabinetPosition = cabinetPosition;
    }

    // ... existing methods ...
}

