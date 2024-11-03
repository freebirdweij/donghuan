package com.freebirdweij.donghuan.device.data;
//开关电源是用于提供稳定电压的设备。我们可以监控其输入/输出电压、输出电流、负载等信息。
public class SwitchingPowerSupply extends Device {
    private double inputVoltage;
    private double outputVoltage;
    private double outputCurrent;
    private double loadPercentage;

    // 构造方法
    public SwitchingPowerSupply(String deviceId, String deviceName, String location, String status,
                                double inputVoltage, double outputVoltage, double outputCurrent, double loadPercentage) {
        super(deviceId, deviceName, "Switching Power Supply", location, status);
        this.inputVoltage = inputVoltage;
        this.outputVoltage = outputVoltage;
        this.outputCurrent = outputCurrent;
        this.loadPercentage = loadPercentage;
    }

    // 开关电源设备独有的方法
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

    public double getOutputCurrent() {
        return outputCurrent;
    }

    public void setOutputCurrent(double outputCurrent) {
        this.outputCurrent = outputCurrent;
    }

    public double getLoadPercentage() {
        return loadPercentage;
    }

    public void setLoadPercentage(double loadPercentage) {
        this.loadPercentage = loadPercentage;
    }

    @Override
    public void monitor() {
        System.out.println("Monitoring Switching Power Supply: " + getDeviceName());
        System.out.println("Input Voltage: " + inputVoltage + "V");
        System.out.println("Output Voltage: " + outputVoltage + "V");
        System.out.println("Output Current: " + outputCurrent + "A");
        System.out.println("Load Percentage: " + loadPercentage + "%");
    }

    @Override
    public Object getData() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getData'");
    }
}

