package com.jiaos.shijianqudong;

import java.util.EventListener;

/**
 * @（#）:WriterListener.java
 * @description:
 * @author: jiaosen 2017/10/25
 * @version: Version 1.0
 */
public interface WriterListener extends EventListener {
    void listenNovel(WriteEvent writeEvent);
}
