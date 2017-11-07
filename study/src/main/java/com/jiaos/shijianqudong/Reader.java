package com.jiaos.shijianqudong;

/**
 * @（#）:Reader.java
 * @description:
 * @author: jiaosen 2017/10/25
 * @version: Version 1.0
 */
public class Reader implements WriterListener {

    private String name;

    public Reader(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //关注一个作者
    public void subscribe(String writerName){
        WriterManager.getInstance().getWriter(writerName).registerListener(this);
    }

    //取关一个坐着
    public void unsubscribe(String writerName){
        WriterManager.getInstance().getWriter(writerName).unregisterListener(this);
    }

    @Override
    public void listenNovel(WriteEvent writeEvent) {
        Writer writer = writeEvent.getWriter();
        System.out.println(name + "知道" + writer.getName() + "发布新书《" +writer.getLastNovel()+ "》");
    }
}
