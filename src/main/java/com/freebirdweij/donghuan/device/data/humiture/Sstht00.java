package com.freebirdweij.donghuan.device.data.humiture;

import com.freebirdweij.donghuan.device.data.base.Device;
import com.freebirdweij.donghuan.device.data.base.DeviceLocation;

// 添加设备信息注解
public class Sstht00 extends Device{

    public Sstht00(String deviceId, String deviceName, String deviceType, String deviceModel,DeviceLocation location, String status) {
       super(deviceId, deviceName, deviceType, deviceModel, location, status);
    }

    @Override
    public void monitor() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'monitor'");
    }

}
