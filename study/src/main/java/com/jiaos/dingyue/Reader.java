package com.jiaos.dingyue;

import java.util.Observable;
import java.util.Observer;

/**
 * @（#）:Reader.java
 * @description: 读者类 要实现观察者接口
 * @author: jiaosen 2017/10/25
 * @version: Version 1.0
 */
public class Reader implements Observer{

    private String name;

    public Reader(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //读者可以关注一位作者，关注则代表把自己加到作者的观察列表里面
    public void subscribe(String writerName){
        WriterManager.getInstance().getWriter(writerName).addObserver(this);
    }

    //取关,代表将自己从作者观察者删除
    public void unsubscribe(String writerName){
        WriterManager.getInstance().getWriter(writerName).deleteObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof Writer){
            Writer writer = (Writer)o;
            System.out.println(name + "知道" + writer.getName() + "发布了新书《"+writer.getLastNovel()+"》");
        }
    }
}
