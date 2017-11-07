package com.jiaos.dingyue;

import java.util.HashMap;
import java.util.Map;

/**
 * @（#）:WriterManager.java
 * @description:
 * @author: jiaosen 2017/10/25
 * @version: Version 1.0
 */
public class WriterManager {
    private Map<String,Writer> writerMap = new HashMap<>();

    //添加作者
    public void add(Writer writer){
        writerMap.put(writer.getName(),writer);
    }

    //根据名字获取作者
    public Writer getWriter(String name){
        return writerMap.get(name);
    }

    private WriterManager(){}

    public static WriterManager getInstance(){
        return WriterManagerInstance.writerManager;
    }

    private static class WriterManagerInstance{
        private static WriterManager writerManager = new WriterManager();
    }

}