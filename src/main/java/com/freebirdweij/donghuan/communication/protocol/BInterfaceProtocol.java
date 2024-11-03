package com.freebirdweij.donghuan.communication.protocol;

import com.freebirdweij.donghuan.communication.protocol.base.CommunicationProtocol;

// B 接口协议类（假设的实现，具体实现需根据实际协议规范）
public class BInterfaceProtocol implements CommunicationProtocol {
    private BInterfaceConnection connection; // B 接口连接
    private String deviceAddress; // 设备地址
    private int port; // 端口号

    public BInterfaceProtocol(String deviceAddress, int port) {
        this.deviceAddress = deviceAddress;
        this.port = port;
    }

    @Override
    public void connect() {
        try {
            connection = new BInterfaceConnection(this.deviceAddress, this.port);
        } catch (Exception e) {
            handleError(e);
        }
    }

    @Override
    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                handleError(e);
            }
        }
    }

    @Override
    public String sendData(String data) {
        try {
            connection.sendData(data.getBytes());
            return "Data sent successfully";
        } catch (Exception e) {
            handleError(e);
            return "Failed to send data";
        }
    }

    @Override
    public String receiveData() {
        try {
            byte[] data = connection.receiveData();
            return new String(data);
        } catch (Exception e) {
            handleError(e);
            return "Failed to receive data";
        }
    }

    private void handleError(Exception e) {
        System.out.println("B interface error: " + e.getMessage());
    }

    @Override
    public void sendBytes(byte[] data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sendBytes'");
    }

    @Override
    public byte[] receiveBytes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'receiveBytes'");
    }
}