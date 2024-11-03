package com.freebirdweij.donghuan.device.protocol.modbus;

public class CRC16 {
    public static int calculateCRC(byte[] data, int offset, int length) {
        int crc = 0xFFFF;
        for(int pos = offset; pos < offset + length; pos++) {
            crc ^= (data[pos] & 0xFF);
            for(int i = 0; i < 8; i++) {
                if((crc & 0x0001)!=0) {
                    crc >>= 1;
                    crc ^= 0xA001;
                }
                else
                    crc >>= 1;
            }
        }
        return crc;
    }
}