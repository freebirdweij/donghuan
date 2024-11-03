package com.freebirdweij.donghuan.communication.protocol.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ProtocolManager 类用于管理不同协议的连接和数据传输。
 */
public class ProtocolManager {
    private static final Logger logger = LoggerFactory.getLogger(ProtocolManager.class);
    private CommunicationProtocol protocol;

    /**
     * 设置当前使用的协议。
     * @param protocol 要设置的协议
     */
    public void setProtocol(CommunicationProtocol protocol) {
        this.protocol = protocol;
        if (protocol != null) {
            logger.info("Protocol set to: {}", protocol.getClass().getSimpleName());
        } else {
            logger.warn("Protocol set to null");
        }
    }

    /**
     * 连接到设备。
     */
    public void connect() {
        if (protocol != null) {
            protocol.connect();
            logger.info("Connected using protocol: {}", protocol.getClass().getSimpleName());
        } else {
            logger.error("No protocol set");
        }
    }

    /**
     * 断开与设备的连接。
     */
    public void disconnect() {
        if (protocol != null) {
            protocol.disconnect();
            logger.info("Disconnected from protocol: {}", protocol.getClass().getSimpleName());
        } else {
            logger.error("No protocol set");
        }
    }

    /**
     * 发送数据到设备。
     * @param data 要发送的数据
     * @return 发送结果
     */
    public String sendData(String data) {
        if (protocol != null) {
            logger.info("Sending data using protocol: {}", protocol.getClass().getSimpleName());
            return protocol.sendData(data);
        }
        logger.error("No protocol set for sending data");
        return null;
    }

    /**
     * 从设备接收数据。
     * @return 接收到的数据
     */
    public String receiveData() {
        if (protocol != null) {
            logger.info("Receiving data using protocol: {}", protocol.getClass().getSimpleName());
            return protocol.receiveData();
        }
        logger.error("No protocol set for receiving data");
        return null;
    }
}
