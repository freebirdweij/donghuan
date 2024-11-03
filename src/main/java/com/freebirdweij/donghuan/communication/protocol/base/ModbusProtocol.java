package com.freebirdweij.donghuan.communication.protocol.base;

/**
 * ModbusProtocol 抽象类实现了 Modbus 协议的基本逻辑。
 */
public abstract class ModbusProtocol implements CommunicationProtocol {
    @Override
    public void connect() {
        // 实现连接逻辑
    }

    @Override
    public void disconnect() {
        // 实现断开连接逻辑
    }

    @Override
    public String sendData(String data) {
        // 实现数据发送逻辑
        return "Sent via Modbus";
    }

    @Override
    public String receiveData() {
        // 实现数据接收逻辑
        return "Data received via Modbus";
    }
}
