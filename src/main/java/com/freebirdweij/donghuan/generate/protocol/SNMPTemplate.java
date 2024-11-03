package com.freebirdweij.donghuan.generate.protocol;

// SNMP协议模板
public class SNMPTemplate extends AbstractProtocolTemplate {

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
    protected byte[] formatRequest(BaseCommand command) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'formatRequest'");
    }

    @Override
    protected Object parseResponse(byte[] response) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'parseResponse'");
    }
    // SNMP协议实现

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
