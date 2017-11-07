package com.jiaos.socket.java;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @（#）:JavaWebSocket.java
 * @description:
 * @author: jiaosen 2017/11/6
 * @version: Version 1.0
 */
@ServerEndpoint("/websocket")
public class JavaWebSocket12 {
    /**
     * 当前连接数量,设计成线程安全
     */
    private static AtomicInteger onlineCount = new AtomicInteger(0);

    /**
     * concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象.若要实现服务端与单一客户端通讯，可以用Map来存放，其中key可以为用户标识
     */
    private static CopyOnWriteArraySet<JavaWebSocket12> webSocekts = new CopyOnWriteArraySet<JavaWebSocket12>();

    private Session session;

    private String roomName;

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocekts.add(this);
        //在线人数加一
        onlineCount.addAndGet(1);
        System.out.println("有新连接，当前连接人数为 + " + onlineCount.get());
    }

    @OnClose
    public void onClose() {
        webSocekts.remove(this);
        onlineCount.addAndGet(-1);
        System.out.println("连接关闭一个，当前连接数目为" + onlineCount.get());
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("接收到来自客户端的消息" + message);
        for(JavaWebSocket12 javaWebSocket : webSocekts){
            try {
                javaWebSocket.session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    @OnError
    public void onError(Session session,Throwable throwable) {
        System.out.println("发生错误");
        throwable.printStackTrace();
    }

    public Session getSession() {
        return session;
    }
}
