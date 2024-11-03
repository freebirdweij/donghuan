package com.freebirdweij.donghuan.device.protocol.modbus;

import java.util.Arrays;

public class ModbusResponse {
    private int slaveId;
    private int functionCode;
    private byte[] data;
    private boolean exception;
    private int exceptionCode;

    public ModbusResponse(byte[] frame) throws Exception {
        if (frame.length < 5) {
            throw new Exception("响应帧长度不足");
        }
        this.slaveId = frame[0] & 0xFF;
        this.functionCode = frame[1] & 0xFF;
        if ((functionCode & 0x80) != 0) {
            // 异常响应
            this.exception = true;
            this.exceptionCode = frame[2] & 0xFF;
            // 验证CRC
            int receivedCrc = (frame[frame.length - 1] << 8) | (frame[frame.length - 2] & 0xFF);
            int calculatedCrc = CRC16.calculateCRC(frame, 0, frame.length - 2);
            if (receivedCrc != calculatedCrc) {
                throw new Exception("CRC校验失败");
            }
        } else {
            // 正常响应
            this.exception = false;
            int dataLength = frame[2] & 0xFF;
            this.data = Arrays.copyOfRange(frame, 3, 3 + dataLength);
            // 验证CRC
            int receivedCrc = (frame[frame.length - 1] << 8) | (frame[frame.length - 2] & 0xFF);
            int calculatedCrc = CRC16.calculateCRC(frame, 0, frame.length - 2);
            if (receivedCrc != calculatedCrc) {
                throw new Exception("CRC校验失败");
            }
        }
    }

    public boolean isException() {
        return exception;
    }

    public int getExceptionCode() {
        return exceptionCode;
    }

    public byte[] getData() {
        return data;
    }

    public int getSlaveId() {
        return slaveId;
    }

    public int getFunctionCode() {
        return functionCode;
    }
}