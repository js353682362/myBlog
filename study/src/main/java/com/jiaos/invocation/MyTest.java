package com.jiaos.invocation;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @（#）:MyTest.java
 * @description:
 * @author: jiaosen 2017/11/1
 * @version: Version 1.0
 */
public class MyTest {

    private AtomicInteger atomicInteger;
    @Test
    public void testInvocation(){
        UserService userService = new UserServiceImpl("name","age");
        InvocationHandler invocationHandler = new MyInvocationHandler(userService);
        userService = MyInvocationHandler.getProxy(UserService.class.getClassLoader(),userService.getClass().getInterfaces(),invocationHandler);
//        userService.getName();
//        userService.getAge();
        System.out.println(userService.getName());
        System.out.println(userService.getAge());
        System.out.println(Arrays.asList(userService.getClass().getAnnotations()));
    }

    @Test
    public void testReflect(){
        try {
            Class clazz = Class.forName("com.jiaos.invocation.UserServiceImpl");
            UserServiceImpl userService = new UserServiceImpl();
            System.out.println("------constructors--------");
            System.out.println(Arrays.toString(userService.getClass().getConstructors()));
            System.out.println(Arrays.toString(userService.getClass().getDeclaredConstructors()));
            System.out.println("------fields--------");
            System.out.println(Arrays.toString(userService.getClass().getFields()));
            System.out.println(Arrays.toString(userService.getClass().getDeclaredFields()));
            System.out.println("------annotations--------");
            System.out.println(Arrays.toString(clazz.getAnnotations()));
            System.out.println(Arrays.toString(userService.getClass().getAnnotations()));
            if(clazz.isAnnotationPresent(Tttttsss.class)){
                System.out.println("success");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        int i = 5;
        i = i++;
        System.out.println(i);

        int j = 0;
        j = j++ + ++j;
        System.out.println(j);
    }

    @Test
    public void testHashCode(){
        String aa = "Aa";
        String bb = "BB";
        System.out.println("aa hashCode = " + aa.hashCode());
        System.out.println("bb hashCode = " + bb.hashCode());

        Map<String,String> hashMap = new HashMap<>();
        hashMap.put(aa,"Aa");
        hashMap.put(bb,"BB");
        System.out.println(hashMap);
    }


    @Test
    public void test(){
        AtomicInteger atomicInteger = new AtomicInteger(0);
        atomicInteger.addAndGet(14);
        System.out.println(atomicInteger.get());
    }
}