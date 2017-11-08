package com.jiaos.task;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @（#）:LoadSocketAnno.java
 * @description:
 * @author: jiaosen 2017/11/8
 * @version: Version 1.0
 */
@Component
public class LoadSocketAnno implements ApplicationListener<ContextRefreshedEvent>{

    private void load(){

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(event.getApplicationContext().getParent() != null){
            load();
        }
    }
}
