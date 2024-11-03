package com.freebirdweij.donghuan.communication.protocol;
//TCP/IP 协议类
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import com.freebirdweij.donghuan.communication.protocol.base.CommunicationProtocol;

/**
 * TcpIpProtocol 类实现了 TCP/IP 协议的通信。
 */
public class TcpIpProtocol implements CommunicationProtocol {
    private Socket socket;
    private String deviceAddress;
    private int port;

    /**
     * 构造方法，初始化 TCP/IP 协议。
     * @param deviceAddress 设备地址
     * @param port 端口号
     */
    public TcpIpProtocol(String deviceAddress, int port) {
        this.deviceAddress = deviceAddress;
        this.port = port;
    }

    /**
     * 连接到设备。
     */
    @Override
    public void connect() {
        try {
            socket = new Socket(deviceAddress, port);
        } catch (IOException e) {
            handleError(e);
        }
    }

    /**
     * 断开与设备的连接。
     */
    @Override
    public void disconnect() {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                handleError(e);
            }
        }
    }

    /**
     * 发送数据到设备。
     * @param data 要发送的数据
     * @return 发送结果
     */
    @Override
    public String sendData(String data) {
        try (OutputStream outputStream = socket.getOutputStream()) {
            outputStream.write(data.getBytes());
            return "Data sent successfully";
        } catch (IOException e) {
            handleError(e);
            return "Failed to send data";
        }
    }

    /**
     * 从设备接收数据。
     * @return 接收到的数据
     */
    @Override
    public String receiveData() {
        try (InputStream inputStream = socket.getInputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);
            if (bytesRead > 0) {
                return new String(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            handleError(e);
        }
        return "Failed to receive data";
    }

    /**
     * 处理错误。
     * @param e 异常
     */
    private void handleError(Exception e) {
        System.out.println("TCP/IP error: " + e.getMessage());
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
