package com.jsen.blog.study.taskexecuter;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @（#）:TaskExcuterConfig.java
 * @description:
 * @author: jiaosen 2017/12/19
 * @version: Version 1.0
 */
@Configuration
@ComponentScan(value = "com.jsen.blog.study.taskexecuter")
@EnableAsync   //开启异步任务支持
public class TaskExcuterConfig implements AsyncConfigurer {

    /**
     * 获得一个基于线程池TaskExcutor
     *
     * @return
     */
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(5);
        taskExecutor.setMaxPoolSize(10);
        taskExecutor.setQueueCapacity(25);
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
}
