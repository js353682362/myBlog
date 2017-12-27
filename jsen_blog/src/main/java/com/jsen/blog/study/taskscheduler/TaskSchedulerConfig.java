package com.jsen.blog.study.taskscheduler;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @（#）:TaskSchedulerConfig.java
 * @description:
 * @author: jiaosen 2017/12/19
 * @version: Version 1.0
 */
@Configuration
@ComponentScan(value = "com.jsen.blog.study.taskscheduler")
@EnableScheduling // 开启对计划任务的支持
public class TaskSchedulerConfig {
}
