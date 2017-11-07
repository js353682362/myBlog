package com.jiaos.socket.java.event;

/**
 * @（#）:SessionJoinEvent.java
 * @description:
 * @author: jiaosen 2017/11/7
 * @version: Version 1.0
 */
public class SessionJoinEvent extends SessionEvent{
    private String eventName;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public SessionJoinEvent(Object source) {
        super(source);
    }
}
