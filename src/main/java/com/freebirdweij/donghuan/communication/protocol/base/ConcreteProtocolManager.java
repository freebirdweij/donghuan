package com.freebirdweij.donghuan.communication.protocol.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ConcreteProtocolManager 类用于管理具体的协议实现。
 */
public class ConcreteProtocolManager extends ProtocolManager {
    private static final Logger logger = LoggerFactory.getLogger(ConcreteProtocolManager.class);
    private CommunicationProtocol protocol;

    @Override
    public void setProtocol(CommunicationProtocol protocol) {
        this.protocol = protocol;
        if (protocol != null) {
            logger.info("Protocol set to: {}", protocol.getClass().getSimpleName());
        } else {
            logger.warn("Protocol set to null");
        }
    }

    @Override
    public void connect() {
        if (protocol != null) {
            protocol.connect();
            logger.info("Connected using protocol: {}", protocol.getClass().getSimpleName());
        } else {
            logger.error("No protocol set");
        }
    }

    @Override
    public void disconnect() {
        if (protocol != null) {
            protocol.disconnect();
            logger.info("Disconnected from protocol: {}", protocol.getClass().getSimpleName());
        } else {
            logger.error("No protocol set");
        }
    }

    @Override
    public String sendData(String data) {
        if (protocol != null) {
            logger.info("Sending data using protocol: {}", protocol.getClass().getSimpleName());
            return protocol.sendData(data);
        }
        logger.error("No protocol set for sending data");
        return "Failed to send data";
    }

    @Override
    public String receiveData() {
        if (protocol != null) {
            logger.info("Receiving data using protocol: {}", protocol.getClass().getSimpleName());
            return protocol.receiveData();
        }
        logger.error("No protocol set for receiving data");
        return "Failed to receive data";
    }
}
