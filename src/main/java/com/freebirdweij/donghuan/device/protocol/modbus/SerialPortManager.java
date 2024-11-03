package com.freebirdweij.donghuan.device.protocol.modbus;

import gnu.io.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SerialPortManager implements SerialPortEventListener {
    private String portName;
    private int baudRate;
    private int dataBits;
    private int stopBits;
    private int parity;

    private SerialPort serialPort;
    private InputStream input;
    private OutputStream output;
    private byte[] buffer = new byte[256];
    private int bufferPos = 0;

    private byte[] readBuffer;
 
    public SerialPortManager(String portName, int baudRate, int dataBits, int stopBits, int parity) {
        this.portName = portName;
        this.baudRate = baudRate;
        this.dataBits = dataBits;
        this.stopBits = stopBits;
        this.parity = parity;
    }

    public void open() throws Exception {
        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
        if (portIdentifier.isCurrentlyOwned()) {
            throw new Exception("端口被占用");
        }
        CommPort commPort = portIdentifier.open(this.getClass().getName(), 2000);
        if (commPort instanceof SerialPort) {
            serialPort = (SerialPort) commPort;
            serialPort.setSerialPortParams(baudRate, dataBits, stopBits, parity);
            input = serialPort.getInputStream();
            output = serialPort.getOutputStream();
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
        } else {
            throw new Exception("不是一个串口");
        }
    }

    public void close() {
        if (serialPort != null) {
            serialPort.removeEventListener();
            serialPort.close();
        }
    }

    public void write(byte[] data) throws IOException {
        output.write(data);
        output.flush();
    }

    public byte[] read() throws Exception {
        // 简单实现：等待一段时间后返回缓冲区数据
        // 实际应用中应更加复杂，如超时处理、帧完整性检查等
        Thread.sleep(100); // 等待数据接收
        synchronized (this) {
            if (bufferPos > 0) {
                readBuffer = new byte[bufferPos];
                System.arraycopy(buffer, 0, readBuffer, 0, bufferPos);
                bufferPos = 0;
                return readBuffer;
            } else {
                throw new Exception("没有接收到数据");
            }
        }
    }

    @Override
    public void serialEvent(SerialPortEvent event) {
        if (event.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                int available = input.available();
                byte[] tempBuffer = new byte[available];
                input.read(tempBuffer);
                synchronized (this) {
                    if (bufferPos + available < buffer.length) {
                        System.arraycopy(tempBuffer, 0, buffer, bufferPos, available);
                        bufferPos += available;
                    } else {
                        // 扩展缓冲区或处理溢出
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}