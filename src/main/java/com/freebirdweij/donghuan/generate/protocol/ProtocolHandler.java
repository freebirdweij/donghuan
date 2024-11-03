package com.freebirdweij.donghuan.generate.protocol;

/**
 * 协议模板基础架构
 */
// 协议处理基础接口
public interface ProtocolHandler {
    void connect(ConnectionConfig config);
    byte[] read(ReadCommand command);
    void write(WriteCommand command, byte[] data);
    void disconnect();
}