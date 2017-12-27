package com.jsen.blog.study.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @（#）:ProfileConfig.java
 * @description:
 * @author: jiaosen 2017/12/15
 * @version: Version 1.0
 */
@Configuration
public class ProfileConfig {

    @Bean
    @Profile(value = "dev")
    public DemoBean devDemoBean(){
        return new DemoBean("from development profile");
    }

    @Bean
    @Profile(value = "prod")
    public DemoBean prodDemoBean(){
        return new DemoBean("from production profile");
    }
}
