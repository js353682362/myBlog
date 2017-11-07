package com.jiaos.shijianqudong;

import java.util.HashSet;
import java.util.Set;

/**
 * @（#）:Writer.java
 * @description:
 * @author: jiaosen 2017/10/25
 * @version: Version 1.0
 */
public class Writer {
    private String name;

    private String lastNovel;

    private Set<WriterListener> writerListeners = new HashSet<>();//包含一个自己监听器的列表

    public Writer(String name){
        this.name = name;
        WriterManager.getInstance().add(this);
    }

    public void addNovel(String novel){
        System.out.println(name + "发布了新书《"+novel+"》");
        lastNovel = novel;
        fireEvent();
    }

    //发布新书
    private void fireEvent(){
        WriteEvent writeEvent = new WriteEvent(this);
        for(WriterListener writerListener : writerListeners){
            writerListener.listenNovel(writeEvent);
        }
    }

    //注册成为自己监听器
    public void registerListener(WriterListener writeListener){
        writerListeners.add(writeListener);
    }

    //给外部注销的方法
    public void unregisterListener(WriterListener writeListener){
        writerListeners.remove(writeListener);
    }

    public String getName() {
        return name;
    }

    public String getLastNovel() {
        return lastNovel;
    }
}
