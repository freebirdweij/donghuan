package com.freebirdweij.donghuan.communication.method.serial;

import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author
 * @date 2023-07-01 17:06
 * @since 1.8
 */
public class Serial232Listener implements SerialPortEventListener {

    InputStream inputStream;
    OutputStream outputStream;
    String format;

    public Serial232Listener(InputStream input, OutputStream output, String format){
        inputStream = input;
        outputStream = output;
        this.format = format;
    }

    @Override
    public void serialEvent(SerialPortEvent event) {
        switch (event.getEventType()) {
            case SerialPortEvent.BI:
            case SerialPortEvent.OE:
            case SerialPortEvent.FE:
            case SerialPortEvent.PE:
            case SerialPortEvent.CD:
            case SerialPortEvent.CTS:
            case SerialPortEvent.DSR:
            case SerialPortEvent.RI:
            case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
                break;
            case SerialPortEvent.DATA_AVAILABLE:
                // 当有可用数据时读取数据
                byte[] readBuffer = null;
                int availableBytes = 0;
                try {
                    availableBytes = inputStream.available();
                    while (availableBytes > 0) {
                        readBuffer = SerialUtil.readFromPort(inputStream);
                        String needData = Crc16Modbus.byteTo16String(readBuffer);
                        SerialWebSocket.broadcast(needData);
                        availableBytes = inputStream.available();
                    }
                } catch (IOException e) {
                }
            default:
                break;
        }
    }
}
