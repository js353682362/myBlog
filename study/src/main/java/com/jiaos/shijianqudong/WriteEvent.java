package com.jiaos.shijianqudong;

import java.util.EventObject;

/**
 * @（#）:WriteEvent.java
 * @description:
 * @author: jiaosen 2017/10/25
 * @version: Version 1.0
 */
public class WriteEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public WriteEvent(Object source) {
        super(source);
    }

    public Writer getWriter(){
        return (Writer)super.getSource();
    }

}
