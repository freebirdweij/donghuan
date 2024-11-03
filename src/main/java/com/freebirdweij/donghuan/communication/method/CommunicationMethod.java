package com.freebirdweij.donghuan.communication.method;

public abstract class CommunicationMethod {
    // 基本通信参数
    protected String ip;              // IP地址（用于网络通信）
    protected int port;              // 端口号
    protected String comPort;        // 串口号
    protected int baudRate;          // 波特率
    protected int dataBits;          // 数据位
    protected int stopBits;          // 停止位
    protected String parity;         // 校验位
    protected int timeout;           // 超时时间（毫秒）
    protected boolean isConnected;   // 连接状态

    // 获取连接状态
    public boolean isConnected() {
        return isConnected;
    }

    // 设置基本参数的方法
    public void setNetworkParams(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public void setSerialParams(String comPort, int baudRate, int dataBits, 
                              int stopBits, String parity) {
        this.comPort = comPort;
        this.baudRate = baudRate;
        this.dataBits = dataBits;
        this.stopBits = stopBits;
        this.parity = parity;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    // 抽象方法，子类必须实现
    protected abstract boolean init();                    // 初始化通信
    protected abstract boolean connect();                 // 建立连接
    protected abstract boolean disconnect();              // 断开连接
}
