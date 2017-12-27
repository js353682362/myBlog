package com.jsen.blog.study.taskexecuter;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @（#）:AsyncTaskService.java
 * @description:
 * @author: jiaosen 2017/12/19
 * @version: Version 1.0
 */
@Service
public class AsyncTaskService {

    @Async
    public void executeAsyncTask(Integer i){
        System.out.println("执行异步任务：" + i);
    }

    @Async
    public void executeAsyncTaskPlus(Integer i){
        System.out.println("执行异步任务+1：" + (i+1));
    }
}
