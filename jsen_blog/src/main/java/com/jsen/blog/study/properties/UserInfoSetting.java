package com.jsen.blog.study.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @（#）:UserInfoSetting.java
 * @description:
 * @author: jiaosen 2017/12/22
 * @version: Version 1.0
 */
@Component
@ConfigurationProperties(prefix = "com.jsen")
public class UserInfoSetting {
    private String name;

    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
