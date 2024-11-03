package com.freebirdweij.donghuan.communication.method.serial;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author
 * @date 2023-07-02 21:05
 * @since 1.8
 */
@Configuration
public class WebSocketConfig {

    /**
     * 开启 websocket 配置
     * @return
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
}


