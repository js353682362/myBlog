package com.jiaos.invocation;

/**
 * @（#）:UserServiceImpl.java
 * @description:
 * @author: jiaosen 2017/11/1
 * @version: Version 1.0
 */
@Tttttsss
public class UserServiceImpl implements UserService {

    private String name;

    private String age;

    public UserServiceImpl() {
    }

    private UserServiceImpl(String name) {
        this.name = name;
    }

    public UserServiceImpl(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String getName() {
        System.out.println("getName");
        return name;
    }

    @Override
    public String getAge() {
        System.out.println("getAge");
        return age;
    }
}
