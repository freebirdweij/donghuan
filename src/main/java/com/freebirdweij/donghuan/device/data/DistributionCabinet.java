package com.freebirdweij.donghuan.device.data;

/**
 * DistributionCabinet 类表示配电柜设备。
 * 用于监控各个支路的电流、电压、开关状态等。
 */
public class DistributionCabinet extends Device {
    private double[] branchCurrents; // 各支路电流
    private double[] branchVoltages; // 各支路电压
    private boolean[] branchSwitchStates; // 各支路开关状态

    /**
     * 构造方法，初始化配电柜。
     * @param deviceId 设备 ID
     * @param deviceName 设备名称
     * @param location 设备位置
     * @param status 设备状态
     * @param branchCurrents 各支路电流
     * @param branchVoltages 各支路电压
     * @param branchSwitchStates 各支路开关状态
     */
    public DistributionCabinet(String deviceId, String deviceName, String location, String status,
                               double[] branchCurrents, double[] branchVoltages, boolean[] branchSwitchStates) {
        super(deviceId, deviceName, "Distribution Cabinet", location, status);
        this.branchCurrents = branchCurrents;
        this.branchVoltages = branchVoltages;
        this.branchSwitchStates = branchSwitchStates;
    }

    /**
     * 获取配电柜数据。
     * @return 配电柜数据
     */
    @Override
    public String getData() {
        StringBuilder data = new StringBuilder();
        for (int i = 0; i < branchCurrents.length; i++) {
            data.append("Branch ").append(i + 1).append(" - Current: ").append(branchCurrents[i]).append("A, Voltage: ").append(branchVoltages[i]).append("V, Switch: ").append(branchSwitchStates[i] ? "On" : "Off").append("\n");
        }
        return data.toString();
    }

    // 配电柜设备独有的方法
    public double[] getBranchCurrents() {
        return branchCurrents;
    }

    public void setBranchCurrents(double[] branchCurrents) {
        this.branchCurrents = branchCurrents;
    }

    public double[] getBranchVoltages() {
        return branchVoltages;
    }

    public void setBranchVoltages(double[] branchVoltages) {
        this.branchVoltages = branchVoltages;
    }

    public boolean[] getBranchSwitchStates() {
        return branchSwitchStates;
    }

    public void setBranchSwitchStates(boolean[] branchSwitchStates) {
        this.branchSwitchStates = branchSwitchStates;
    }

    /**
     * 监控配电柜。
     */
    @Override
    public void monitor() {
        System.out.println("Monitoring Distribution Cabinet: " + getDeviceName());
        for (int i = 0; i < branchCurrents.length; i++) {
            System.out.println("Branch " + (i + 1) + " - Current: " + branchCurrents[i] + "A, Voltage: " + branchVoltages[i] + "V, Switch: " + (branchSwitchStates[i] ? "On" : "Off"));
        }
    }
}
