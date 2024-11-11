package com.freebirdweij.donghuan.device.data.base;

/**
 * PowerMeter 抽象类表示电量仪设备。
 * 提供了电量仪的基本属性和方法。
 */
public abstract class PowerMeter extends Device {
    private double inputVoltage;    // 输入电压
    private double outputVoltage;   // 输出电压
    private double inputCurrent;    // 输入电流
    private double outputCurrent;   // 输出电流
    private double activePower;     // 有功功率
    private double reactivePower;   // 无功功率
    private double apparentPower;   // 视在功率
    private double powerFactor;     // 功率因数
    private double energyConsumed;  // 累计电能消耗

    /**
     * 构造方法，初始化电量仪。
     * @param deviceId 设备 ID
     * @param deviceName 设备名称
     * @param location 设备位置
     * @param status 设备状态
     * @param inputVoltage 输入电压
     * @param outputVoltage 输出电压
     * @param inputCurrent 输入电流
     * @param outputCurrent 输出电流
     * @param activePower 有功功率
     * @param reactivePower 无功功率
     * @param apparentPower 视在功率
     * @param powerFactor 功率因数
     * @param energyConsumed 累计电能消耗
          * @param deviceModel 
          */
         public PowerMeter(String deviceId, String deviceName, DeviceLocation location, String status,
                           double inputVoltage, double outputVoltage, double inputCurrent, double outputCurrent,
                           double activePower, double reactivePower, double apparentPower, double powerFactor,
                           double energyConsumed, String deviceModel) {
             super(deviceId, deviceName, "Power Meter", deviceModel, location, status);
        this.inputVoltage = inputVoltage;
        this.outputVoltage = outputVoltage;
        this.inputCurrent = inputCurrent;
        this.outputCurrent = outputCurrent;
        this.activePower = activePower;
        this.reactivePower = reactivePower;
        this.apparentPower = apparentPower;
        this.powerFactor = powerFactor;
        this.energyConsumed = energyConsumed;
    }

    /**
     * 抽象方法，用于监控电量仪。
     */
    public abstract void monitor();

    // 其他方法
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

    public double getInputCurrent() {
        return inputCurrent;
    }

    public void setInputCurrent(double inputCurrent) {
        this.inputCurrent = inputCurrent;
    }

    public double getOutputCurrent() {
        return outputCurrent;
    }

    public void setOutputCurrent(double outputCurrent) {
        this.outputCurrent = outputCurrent;
    }

    public double getActivePower() {
        return activePower;
    }

    public void setActivePower(double activePower) {
        this.activePower = activePower;
    }

    public double getReactivePower() {
        return reactivePower;
    }

    public void setReactivePower(double reactivePower) {
        this.reactivePower = reactivePower;
    }

    public double getApparentPower() {
        return apparentPower;
    }

    public void setApparentPower(double apparentPower) {
        this.apparentPower = apparentPower;
    }

    public double getPowerFactor() {
        return powerFactor;
    }

    public void setPowerFactor(double powerFactor) {
        this.powerFactor = powerFactor;
    }

    public double getEnergyConsumed() {
        return energyConsumed;
    }

    public void setEnergyConsumed(double energyConsumed) {
        this.energyConsumed = energyConsumed;
    }
}
