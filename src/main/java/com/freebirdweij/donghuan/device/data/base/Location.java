package com.freebirdweij.donghuan.device.data.base;
//地点抽象类
public abstract class Location {
    private String name; // 地点名称
    private String description; // 地点描述
    private double latitude; // 纬度
    private double longitude; // 经度
    private double height; // 高度
    private String country;    // 国家
    private String province;   // 地区/省份
    private String city;       // 城市
    private String district;   // 街区
    private String street;     // 街道
    private String streetNo;   // 门牌号

    public Location(String name, String description, String country, String province, 
                   String city, String district, String street, String streetNo) {
        this.name = name;
        this.description = description;
        this.country = country;
        this.province = province;
        this.city = city;
        this.district = district;
        this.street = street;
        this.streetNo = streetNo;
    }

    public Location(String name2, String type, String floor) {
        //TODO Auto-generated constructor stub
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getHeight() {
        return height;
    }

    public String getCountry() {
        return country;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public String getStreet() {
        return street;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    public abstract String getPositionDetails(); // 抽象方法，子类实现具体细节

    public abstract String getLocationDetails(); // 抽象方法，子类实现具体细节
}
