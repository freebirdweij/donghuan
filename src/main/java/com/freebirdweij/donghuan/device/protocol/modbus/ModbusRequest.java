package com.freebirdweij.donghuan.device.protocol.modbus;

public class ModbusRequest {
    private int slaveId;
    private int functionCode;
    private byte[] data;

    public void setSlaveId(int slaveId) {
        this.slaveId = slaveId;
    }

    public void setFunctionCode(int functionCode) {
        this.functionCode = functionCode;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public byte[] build() {
        byte[] frame = new byte[3 + data.length + 2];
        frame[0] = (byte) slaveId;
        frame[1] = (byte) functionCode;
        System.arraycopy(data, 0, frame, 2, data.length);
        int crc = CRC16.calculateCRC(frame, 0, 2 + data.length);
        frame[2 + data.length] = (byte) (crc & 0xFF);
        frame[3 + data.length] = (byte) ((crc >> 8) & 0xFF);
        return frame;
    }
}