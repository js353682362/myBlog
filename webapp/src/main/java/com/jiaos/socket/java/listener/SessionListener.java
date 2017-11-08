package com.jiaos.socket.java.listener;

import com.jiaos.socket.java.event.SessionEvent;

import java.util.EventListener;

/**
 * @（#）:SessionJoinListener.java
 * @description:
 * @author: jiaosen 2017/11/7
 * @version: Version 1.0
 */
public interface SessionListener extends EventListener {
    void processEvent();

    void initEvent(SessionEvent sessionEvent);
    /**
     * 设置触发事件名称
     * @param eventName
     */
    void setEventName(String eventName);

    /**
     * 获取触发事件名称
     * @return
     */
    String getEventName();

}
