package com.jiaos.socket.java.event;

import javax.websocket.Session;
import java.util.EventObject;

/**
 * @（#）:SessionEvent.java
 * @description:
 * @author: jiaosen 2017/11/7
 * @version: Version 1.0
 */
public abstract class SessionEvent extends EventObject{

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public SessionEvent(Object source) {
        super(source);
    }

    public Session getSession(){
        return (Session) super.getSource();
    }
}
