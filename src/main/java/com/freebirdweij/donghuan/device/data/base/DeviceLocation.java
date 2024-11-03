package com.freebirdweij.donghuan.device.data.base;
//设备地点抽象类
public abstract class DeviceLocation extends Location {
    private String name; // 地点名称
    private String type; // 地点类型（如机房、服务器室等）
    private String floor; // 楼层信息
    private String environment; // 环境条件（如温度、湿度等）

    public DeviceLocation(String name, String type, String floor, String environment) {
        super(name, type, floor);
        this.environment = environment;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getFloor() {
        return floor;
    }

    public String getEnvironment() {
        return environment;
    }

    public abstract String getLocationDetails(); // 抽象方法，子类实现具体细节
}
