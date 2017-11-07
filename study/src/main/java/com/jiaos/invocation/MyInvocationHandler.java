package com.jiaos.invocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @（#）:MyInvocationHandler.java
 * @description:
 * @author: jiaosen 2017/11/1
 * @version: Version 1.0
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    public MyInvocationHandler() {
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        if("getName".equals(method.getName())){
            System.out.println("+++++before" + method.getName() + "+++++");
            result = method.invoke(target,args);
            System.out.println("+++++after" + method.getName() + "+++++");
            return result;
        }else {
            result = method.invoke(target,args);
        }
        return  result;
    }

    public static <T> T getProxy(ClassLoader classLoader,Class<?>[] interfaces,InvocationHandler myInvocationHandler){
        return (T)Proxy.newProxyInstance(classLoader,interfaces, myInvocationHandler);
    }
}
