package com.freebirdweij.donghuan.device.data.base;

public abstract class DistributionCabinet extends Device {
    private double[] branchCurrents;
    private double[] branchVoltages;
    private boolean[] branchSwitchStates;

    public DistributionCabinet(String deviceId, String deviceName, DeviceLocation location, String status,
                               double[] branchCurrents, double[] branchVoltages, boolean[] branchSwitchStates, String deviceModel) {
                                       super(deviceId, deviceName, "Distribution Cabinet", deviceModel, location, status);
        this.branchCurrents = branchCurrents;
        this.branchVoltages = branchVoltages;
        this.branchSwitchStates = branchSwitchStates;
    }

    // 抽象类的 monitor() 方法
    public abstract void monitor();

    // 其他方法
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
}
