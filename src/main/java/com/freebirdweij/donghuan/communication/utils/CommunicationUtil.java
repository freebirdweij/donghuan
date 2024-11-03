package com.freebirdweij.donghuan.communication.utils;

import com.freebirdweij.donghuan.communication.protocol.base.CommunicationProtocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommunicationUtil {
    private static final Logger logger = LoggerFactory.getLogger(CommunicationUtil.class);

    private CommunicationProtocol protocol;

    public CommunicationUtil(CommunicationProtocol protocol) {
        this.protocol = protocol;
    }

    public void connect() {
        if (protocol != null) {
            try {
                logger.info("Connecting using protocol: {}", protocol.getClass().getSimpleName());
                protocol.connect();
            } catch (Exception e) {
                logger.error("Error connecting using protocol: {}", protocol.getClass().getSimpleName(), e);
            }
        } else {
            logger.error("No protocol set for connection");
        }
    }

    public void disconnect() {
        if (protocol != null) {
            try {
                logger.info("Disconnecting using protocol: {}", protocol.getClass().getSimpleName());
                protocol.disconnect();
            } catch (Exception e) {
                logger.error("Error disconnecting using protocol: {}", protocol.getClass().getSimpleName(), e);
            }
        } else {
            logger.error("No protocol set for disconnection");
        }
    }

    public String sendData(String data) {
        if (protocol != null) {
            try {
                logger.info("Sending data using protocol: {}", protocol.getClass().getSimpleName());
                return protocol.sendData(data);
            } catch (Exception e) {
                logger.error("Error sending data using protocol: {}", protocol.getClass().getSimpleName(), e);
                return "Failed to send data";
            }
        } else {
            logger.error("No protocol set for sending data");
            return "No protocol set";
        }
    }

    public String receiveData() {
        if (protocol != null) {
            try {
                logger.info("Receiving data using protocol: {}", protocol.getClass().getSimpleName());
                return protocol.receiveData();
            } catch (Exception e) {
                logger.error("Error receiving data using protocol: {}", protocol.getClass().getSimpleName(), e);
                return "Failed to receive data";
            }
        } else {
            logger.error("No protocol set for receiving data");
            return "No protocol set";
        }
    }
}