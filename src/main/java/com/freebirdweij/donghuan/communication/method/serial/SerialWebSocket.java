package com.freebirdweij.donghuan.communication.method.serial;

import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author
 * @date 2023-07-02 21:07
 * @since 1.8
 */

@Component
@ServerEndpoint("/websocket/{sid}")
public class SerialWebSocket {

    /** Logger instance */
    private final Log log = LogFactory.getLog(getClass());

    /**
     * 缓存通信实例
     */
    private static Map<String,SerialWebSocket> webSocketMap = new ConcurrentHashMap<>(16);

    /**
     * 会话
     */
    private Session session;

    /**
     * 标识
     */
    private String sid;

    /**
     * 建立连接
     * @param sid
     * @param session
     */
    @OnOpen
    public void onOpen(@PathParam("sid") String sid,Session session){
        this.session = session;
        this.sid = sid;
        webSocketMap.put(sid,this);
        //sendMessage(sid,"Hello:");
    }

    /**
     * 关闭连接
     * @param sid
     */
    @OnClose
    public void onClose(@PathParam("sid") String sid){
        try {
            SerialWebSocket socket = webSocketMap.remove(sid);
            if (socket != null){
                socket.session.close();
                socket = null;
            }
        } catch (IOException e) {
            log.error("Close {} exception:"+sid+e);
        }
    }

    /**
     * 接收消息
     * @param message
     */
    @OnMessage
    public void onMessage(String message){
        log.info("sid {} msg {}"+this.sid+message);
    }

    /**
     * 发送消息
     * @param message
     * @param sid
     */
    public static void sendMessage(String sid,String message){
        SerialWebSocket socket = webSocketMap.get(sid);
        if (socket != null){
            try {
                socket.session.getBasicRemote().sendText(message);
            } catch (IOException e) {
            	e.printStackTrace();
            }
        }
    }

    /**
     * 广播消息
     * @param message
     */
    public static void broadcast(String message){
        for (String sid:webSocketMap.keySet()){
            sendMessage(sid,message);
        }
    }

}

