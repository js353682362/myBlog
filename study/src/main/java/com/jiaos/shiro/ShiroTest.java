package com.jiaos.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

/**
 * @（#）:ShiroTest.java
 * @description:
 * @author: jiaosen 2017/11/8
 * @version: Version 1.0
 */
public class ShiroTest {

    @Test
    public void testHelloWorld() {
        // 1.获取SecurityManage工厂,此处使用Init配置文件初始化SecurityManage
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");

        // 2.得到SecurityManager实例并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        // 3.得到Subject及创建用户名/密码身份Token(即用户身份/凭证)
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
        try {
            // 4.登陆
            subject.login(token);
        } catch (AuthenticationException e) {
            // 5.身份验证失败
        }

        if (subject.isAuthenticated()) {
            System.out.println("登陆成功");
        }

        // 断言用户已经登陆
        Assert.assertEquals(true, subject.isAuthenticated());
        // 6.退出
        subject.logout();
    }
}
