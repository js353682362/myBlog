package com.jsen.blog.study.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @（#）:ElConfig.java
 * @description:
 * @author: jiaosen 2017/12/15
 * @version: Version 1.0
 */
@Configuration
@PropertySource(value = "classpath:info.properties")
public class ElConfig {

}
