package com.jiaos.gcz;

/**
 * @（#）:ConcreteObserver2.java
 * @description:
 * @author: jiaosen 2017/10/25
 * @version: Version 1.0
 */
public class ConcreteObserver2 implements Observer{

    @Override
    public void update(Observable o) {
        System.out.println("被观察者2观察到" + o.getClass().getSimpleName() + "发生变化");
        System.out.println("观察者2做出响应");
    }
}
