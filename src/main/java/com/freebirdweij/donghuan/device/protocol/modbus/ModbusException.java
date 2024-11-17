package com.freebirdweij.donghuan.device.protocol.modbus;

public class ModbusException extends Exception {
    private int exceptionCode;

    public ModbusException(int exceptionCode) {
        super("Modbus Exception Code: " + exceptionCode);
        this.exceptionCode = exceptionCode;
    }

     /**
     * 获取异常代码
     * 
     * @return 异常代码
     */
    public int getExceptionCode() {
        return exceptionCode;
    }

}