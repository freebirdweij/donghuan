package com.freebirdweij.donghuan.device.protocol.modbus;

public class ModbusException extends Exception {
    private int exceptionCode;

    public ModbusException(int exceptionCode) {
        super("Modbus Exception Code: " + exceptionCode);
        this.exceptionCode = exceptionCode;
    }

    public int getExceptionCode() {
        return exceptionCode;
    }
}