package com.jiaos.dingyue;

import java.util.Observable;

/**
 * @（#）:Writer.java
 * @description: 作者类，继承被观察者类
 * @author: jiaosen 2017/10/25
 * @version: Version 1.0
 */
public class Writer extends Observable {
    private String name;// 作者名字

    private String lastNovel;// 记录作者最新发布的小说

    public Writer(String name) {
        this.name = name;
        WriterManager.getInstance().add(this);
    }

    // 发布新小说，通知所有关注自己的读者
    public void addNovel(String novel) {
        System.out.println(name + "发布了新书《" + novel + "》");
        lastNovel = novel;
        setChanged();
        notifyObservers();
    }

    public String getName() {
        return name;
    }

    public String getLastNovel() {
        return lastNovel;
    }
}