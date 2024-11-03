package com.freebirdweij.donghuan.generate;

import java.util.Map;

/**
 * 协议处理基类
 */
public abstract class BaseProtocolHandler {

    protected DeviceProtocolConfig config;
    
    public abstract void connect();
    public abstract void disconnect();
    public abstract Map<String, Object> read();
    public abstract void write(String pointId, Object value);
}
