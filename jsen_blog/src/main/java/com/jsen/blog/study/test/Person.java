package com.jsen.blog.study.test;

/**
 * @（#）:Person.java
 * @description:
 * @author: jiaosen 2017/12/25
 * @version: Version 1.0
 */
public class Person {
    private String name;

    private String age;

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
