package com.jiaos.socket.java.listener;

import com.jiaos.socket.java.anno.SessionListenerAnno;
import com.jiaos.socket.java.event.SessionEvent;

/**
 * @（#）:SessionJoinListener.java
 * @description:
 * @author: jiaosen 2017/11/7
 * @version: Version 1.0
 */
@SessionListenerAnno
public class SessionJoinListener implements SessionListener{

    private String eventName;

    public SessionJoinListener() {
        this.setEventName("__join");
    }

    @Override
    public void processEvent(SessionEvent sessionEvent) {

    }

    /**
     * 设置触发事件名称
     *
     * @param eventName
     */
    @Override
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
     * 获取触发事件名称
     *
     * @return
     */
    @Override
    public String getEventName() {
        return eventName;
    }
}
