package com.freebirdweij.donghuan.communication.method.serial;

import lombok.Data;

/**
 * @author
 * @date 2023-07-02 22:58
 * @since 1.8
 */
@Data
public class SerialEntity {

    private String portId;
    private int bitRate;
    private int dataBit;
    private int stopBit;
    private String checkBit;
    private String format;

}

