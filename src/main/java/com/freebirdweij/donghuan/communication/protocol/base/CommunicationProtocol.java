package com.freebirdweij.donghuan.communication.protocol.base;

/**
 * CommunicationProtocol 接口定义了通信协议的基本操作。
 */
public interface CommunicationProtocol {
    /**
     * 连接到设备。
     */
    void connect();

    /**
     * 断开与设备的连接。
     */
    void disconnect();

    /**
     * 发送数据到设备。
     * @param data 要发送的数据
     * @return 发送结果
     */
    String sendData(String data);

    /**
     * 从设备接收数据。
     * @return 接收到的数据
     */
    String receiveData();

    /**
     * 发送字节数据到设备。
     * @param data 要发送的字节数据
     */
    public void sendBytes(byte[] data);

    /**
     * 从设备接收字节数据。
     * @return 接收到的字节数据
     */
    public byte[] receiveBytes();

}
