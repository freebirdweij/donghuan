package com.freebirdweij.donghuan.device.data;
//UPS设备类
public class UPSDevice extends Device {
    private double inputVoltage;
    private double outputVoltage;
    private double loadPercentage;
    private double batteryLevel;

    @Override
    public String getData() {
        return "Input Voltage: " + inputVoltage + "V, Output Voltage: " + outputVoltage + "V, Load Percentage: " + loadPercentage + "%, Battery Level: " + batteryLevel + "%";
    }

    // 构造方法
    public UPSDevice(String deviceId, String deviceName, String location, String status,
                     double inputVoltage, double outputVoltage, double loadPercentage, double batteryLevel) {
        super(deviceId, deviceName, "UPS", location, status);
        this.inputVoltage = inputVoltage;
        this.outputVoltage = outputVoltage;
        this.loadPercentage = loadPercentage;
        this.batteryLevel = batteryLevel;
    }

    // UPS 设备独有的方法
    public double getInputVoltage() {
        return inputVoltage;
    }

    public void setInputVoltage(double inputVoltage) {
        this.inputVoltage = inputVoltage;
    }

    public double getOutputVoltage() {
        return outputVoltage;
    }

    public void setOutputVoltage(double outputVoltage) {
        this.outputVoltage = outputVoltage;
    }

    public double getLoadPercentage() {
        return loadPercentage;
    }

    public void setLoadPercentage(double loadPercentage) {
        this.loadPercentage = loadPercentage;
    }

    public double getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(double batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    @Override
    public void monitor() {
        System.out.println("Monitoring UPS Device: " + getDeviceName());
        System.out.println("Input Voltage: " + inputVoltage + "V");
        System.out.println("Output Voltage: " + outputVoltage + "V");
        System.out.println("Load Percentage: " + loadPercentage + "%");
        System.out.println("Battery Level: " + batteryLevel + "%");
    }
}

