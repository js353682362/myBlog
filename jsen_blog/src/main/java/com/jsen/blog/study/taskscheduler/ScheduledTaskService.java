package com.jsen.blog.study.taskscheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @（#）:ScheduledTaskService.java
 * @description:
 * @author: jiaosen 2017/12/19
 * @version: Version 1.0
 */
@Service
public class ScheduledTaskService {
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000) //使用fixedRate属性每隔固定时间执行
    public void reportCurrentTime(){
        System.out.println("每隔5秒执行一次：" + SIMPLE_DATE_FORMAT.format(Calendar.getInstance().getTime()));
    }

    @Scheduled(cron = "0 31 11 ? * *") //每天11点28分执行 cron是linux和unix系统下定时任务
    public void fixTimeExecution(){
        System.out.println("在指定时间" + SIMPLE_DATE_FORMAT.format(Calendar.getInstance().getTime()) + "执行");
    }
}
