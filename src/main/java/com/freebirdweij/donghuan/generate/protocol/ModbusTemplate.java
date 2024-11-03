package com.freebirdweij.donghuan.generate.protocol;

/**
 * 常用协议预置实现
 */
// Modbus协议模板
public class ModbusTemplate extends AbstractProtocolTemplate {
    @Override
    protected byte[] formatRequest(BaseCommand command) {
        // Modbus请求格式化
        if (command instanceof ModbusReadCommand) {
            ModbusReadCommand cmd = (ModbusReadCommand) command;
            return formatModbusRequest(cmd.getFunctionCode(), cmd.getAddress(), cmd.getLength());
        }
        // ...
        return null;
    }

    private byte[] formatModbusRequest(Object functionCode, Object address, Object length) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'formatModbusRequest'");
    }

    @Override
    public void connect(ConnectionConfig config) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'connect'");
    }

    @Override
    public byte[] read(ReadCommand command) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public void write(WriteCommand command, byte[] data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'write'");
    }

    @Override
    public void disconnect() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'disconnect'");
    }

    @Override
    protected Object parseResponse(byte[] response) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'parseResponse'");
    }

    @Override
    protected byte[] sendRequest(byte[] requestData) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sendRequest'");
    }

    @Override
    protected byte[] read(TemplateReadCommand templateReadCommand) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }
}