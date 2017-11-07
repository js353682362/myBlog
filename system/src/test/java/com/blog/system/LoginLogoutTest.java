package com.blog.system;

import org.junit.Test;

/**
 * @（#）:LoginLogoutTest.java
 * @description:
 * @author: jiaosen 2017/8/14
 * @version: Version 1.0
 */
public class LoginLogoutTest {

    @Test
    public void testHelloWorld() {
        // 1.获取SecurityManager工厂，此处使用ini配置文件初始化SecurityManager
//        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
//
//        //2.得到SecurityManager实例，并绑定给SecurityUtils
//        SecurityManager securityManager = factory.getInstance();
//        SecurityUtils.setSecurityManager(securityManager);
//
//        //3.得到Subject及创建用户名/密码身份验证Token（即用户/凭证）
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
//        try {
//            //4、登录，即身份验证
//            subject.login(token);
//        }
//
//
//        //6、退出
//        subject.logout();
    }
}
