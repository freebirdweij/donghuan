package com.freebirdweij.donghuan.communication.method;

/**
 * CommunicationManager 类用于管理和使用不同的通信方式。
 */
public class CommunicationManager {
    private CommunicationMethod communicationMethod;

    public void setCommunicationMethod(CommunicationMethod method) {
        this.communicationMethod = method;
    }

    public void connect() {
        if (communicationMethod != null) {
            communicationMethod.connect();
        }
    }

    public void disconnect() {
        if (communicationMethod != null) {
            communicationMethod.disconnect();
        }
    }
}
