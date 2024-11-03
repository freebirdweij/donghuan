package com.freebirdweij.donghuan.generate.protocol;

// 抽象的协议模板类
public abstract class AbstractProtocolTemplate implements ProtocolHandler {
    // 模板方法定义协议处理的基本流程
    protected byte[] processCommand(BaseCommand command) {
        byte[] requestData = formatRequest(command);  // 由具体协议实现
        byte[] responseData = sendRequest(requestData);
        return (byte[]) parseResponse(responseData);  // 由具体协议实现
    }
    
    protected abstract byte[] sendRequest(byte[] requestData);

    // 由子类实现的抽象方法
    protected abstract byte[] formatRequest(BaseCommand command);
    protected abstract Object parseResponse(byte[] response);

    protected abstract byte[] read(TemplateReadCommand templateReadCommand);
}