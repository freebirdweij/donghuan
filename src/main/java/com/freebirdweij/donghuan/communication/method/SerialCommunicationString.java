package com.freebirdweij.donghuan.communication.method;

/**
 * SerialCommunicationString 类用于处理串行通信中的字符串数据。
 */
public class SerialCommunicationString extends CommunicationMethod {
    @Override
    public boolean connect() {
        return isConnected;
        // TODO: 实现连接逻辑
    }

    @Override
    public boolean disconnect() {
        return isConnected;
        // TODO: 实现断开连接逻辑
    }

    @Override
    protected boolean init() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'init'");
    }

}
