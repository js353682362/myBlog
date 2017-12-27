package com.jsen.blog.study.conditional;

import com.jsen.blog.study.conditional.interfacess.ListService;
import com.jsen.blog.study.conditional.service.LinuxListService;
import com.jsen.blog.study.conditional.service.WindowsListService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @（#）:ConditionConfig.java
 * @description:
 * @author: jiaosen 2017/12/19
 * @version: Version 1.0
 */
@Configuration
public class ConditionConfig {

    @Bean
    @Conditional(value = WindowsCondition.class)
    public ListService windowsListService(){
        return new WindowsListService();
    }

    @Bean
    @Conditional(value = LinuxCondition.class)
    public ListService linuxListService(){
        return new LinuxListService();
    }
}
