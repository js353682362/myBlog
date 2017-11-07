package com.jiaos.socket.java;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @（#）:JavaWebSocketManage.java
 * @description:
 * @author: jiaosen 2017/11/6
 * @version: Version 1.0
 */
public class WebSocketSessionManage {

    private ConcurrentHashMap<String, CopyOnWriteArraySet<JavaWebSocket>> roomMember = new ConcurrentHashMap<String, CopyOnWriteArraySet<JavaWebSocket>>();

    private CopyOnWriteArraySet<JavaWebSocket> javaWebSockets = new CopyOnWriteArraySet<JavaWebSocket>();

    /**
     * 新增连接
     * @param javaWebSocket
     */
    public void addWebSocket(JavaWebSocket javaWebSocket) {
        javaWebSockets.add(javaWebSocket);
    }

    /**
     * 关闭连接
     * @param javaWebSocket
     */
    public void remove(JavaWebSocket javaWebSocket) {
        javaWebSockets.remove(javaWebSocket);
        String roomName = javaWebSocket.getRoomName();

        CopyOnWriteArraySet<JavaWebSocket> javaWebSockets = roomMember.get(roomName);
        if (javaWebSockets == null) {
            javaWebSockets = new CopyOnWriteArraySet<JavaWebSocket>();
            javaWebSockets.add(javaWebSocket);
            roomMember.put(roomName,javaWebSockets);
        } else {
            javaWebSockets.add(javaWebSocket);
        }
    }

    public int getConnCount(){
        return javaWebSockets.size();
    }

    private WebSocketSessionManage() {
    }

    public static WebSocketSessionManage getInstance() {
        return WebSocketSessionManageInstance.javaWebSocketManage;
    }

    private static class WebSocketSessionManageInstance {
        private static WebSocketSessionManage javaWebSocketManage = new WebSocketSessionManage();
    }
}
