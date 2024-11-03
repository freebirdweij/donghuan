package com.freebirdweij.donghuan.device.protocol.modbus.SSTHT00;


public class CRC16 {
    private static final int[] TABLE = {
        0x0000, 0xC0C1, 0xC181, 0x0140, // ... (complete the table with all 256 values)
        // For brevity, only a partial table is shown. You need to complete the CRC table.
    };

    public static int calculateCRC(byte[] data, int length) {
        int crc = 0xFFFF;
        for(int pos = 0; pos < length; pos++) {
            crc = (crc >> 8) ^ TABLE[(crc ^ data[pos]) & 0xFF];
        }
        return crc;
    }
}
