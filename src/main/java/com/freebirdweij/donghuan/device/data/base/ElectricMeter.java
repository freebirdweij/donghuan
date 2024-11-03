package com.freebirdweij.donghuan.device.data.base;
//如果电量仪主要监测三相电压和三相电流，可以在上述抽象类的基础上进行扩展和修改。
public abstract class ElectricMeter {

    // 三相电压 A 相
    protected double voltageA;
    // 三相电压 B 相
    protected double voltageB;
    // 三相电压 C 相
    protected double voltageC;

    // 三相电流 A 相
    protected double currentA;
    // 三相电流 B 相
    protected double currentB;
    // 三相电流 C 相
    protected double currentC;

    // 获取 A 相电压的抽象方法
    public abstract double getVoltageA();

    // 获取 B 相电压的抽象方法
    public abstract double getVoltageB();

    // 获取 C 相电压的抽象方法
    public abstract double getVoltageC();

    // 获取 A 相电流的抽象方法
    public abstract double getCurrentA();

    // 获取 B 相电流的抽象方法
    public abstract double getCurrentB();

    // 获取 C 相电流的抽象方法
    public abstract double getCurrentC();
}
