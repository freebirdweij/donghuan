package com.freebirdweij.donghuan.communication.method.serial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

/**
 * @author
 * @date 2023-07-01 12:41
 * @since 1.8
 */
@SpringBootApplication
@EnableWebSocket
@ServletComponentScan
public class SerialApplication {

    public static void main(String[] args) {
        SpringApplication.run(SerialApplication.class,args);
    }

}
