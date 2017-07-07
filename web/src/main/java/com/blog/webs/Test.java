package com.blog.webs;

import com.blog.webs.httpclient.MyBlogClient;

import java.io.IOException;
import java.io.InputStream;

/**
 * @（#）:Test.java
 * @description:
 * @author: jiaosen 2017/7/5
 * @version: Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        String s = "1.xxx 2.xxxxx 3.xxxxxxx";
        System.out.println(s.replaceAll("(\\d+\\.)", "\r\n$1"));

        InputStream inputStream = Test.class.getResourceAsStream("/application.properties");
        try {
            byte[] tt = new byte[inputStream.available()];
            int z;
            while ((z = inputStream.read(tt, 0, tt.length)) != -1) {
                System.out.println(new String(tt, "utf-8"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}