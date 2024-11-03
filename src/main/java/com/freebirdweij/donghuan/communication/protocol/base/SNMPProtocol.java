package com.freebirdweij.donghuan.communication.protocol.base;

/**
 * SNMPProtocol 抽象类实现了 SNMP 协议的基本逻辑。
 */
public abstract class SNMPProtocol implements CommunicationProtocol {
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
