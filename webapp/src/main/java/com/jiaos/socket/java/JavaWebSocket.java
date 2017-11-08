package com.jiaos.socket.java;

import com.jiaos.socket.java.event.SessionJoinEvent;
import com.jiaos.socket.java.listener.SessionJoinListener;
import com.jiaos.socket.java.listener.SessionListener;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.ArrayList;
import java.util.List;

/**
 * @（#）:JavaWebSocket.java
 * @description:
 * @author: jiaosen 2017/11/6
 * @version: Version 1.0
 */
@ServerEndpoint("/websocket")
public class JavaWebSocket {

    private Session session;

    private String roomName;

    private List<SessionListener> sessionListeners;

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        WebSocketSessionManage webSocketSessionManage = WebSocketSessionManage.getInstance();
        webSocketSessionManage.addWebSocket(this);
        System.out.println("当前总连接数:" + webSocketSessionManage.getConnCount());
        addListener();
    }

    public void addListener(){
        sessionListeners = new ArrayList<>();
        SessionJoinEvent sessionJoinEvent = new SessionJoinEvent(session);
        SessionJoinListener sessionJoinListener = new SessionJoinListener();
        sessionJoinListener.initEvent(sessionJoinEvent);
    }

    @OnClose
    public void onClose() {
        WebSocketSessionManage.getInstance().remove(this);
    }

    @OnMessage
    public void onMessage(String message, Session session) {

    }

    public void processEvent(String message){

    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("发生错误");
        throwable.printStackTrace();
    }

    public Session getSession() {
        return session;
    }

    public String getRoomName() {
        return roomName;
    }
}
