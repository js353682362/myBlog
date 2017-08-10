package com.blog.system;

/**
 * @（#）:CalculateTest.java
 * @description:
 * @author: jiaosen 2017/8/10
 * @version: Version 1.0
 */
public class CalculateTest {

    public static void main(String[] args) {
        Integer a = 10;

        a = a++ + ++a;
        System.out.println(a);

        a = 10;
        a = a++;
        System.out.println(a);

        a = 10;
        Integer b = a++ + a;
        System.out.println(b);

        a = 10;
        Integer d = ++a + a;
        System.out.println(d);

        a = 10;
        Integer e = ++a + ++a;
        System.out.println(e);
    }
}
