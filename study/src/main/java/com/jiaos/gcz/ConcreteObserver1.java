package com.jiaos.gcz;

/**
 * @（#）:ConcreteObserver1.java
 * @description:
 * @author: jiaosen 2017/10/25
 * @version: Version 1.0
 */
public class ConcreteObserver1 implements Observer {
    @Override
    public void update(Observable o) {
        System.out.println("被观察者1观察到" + o.getClass().getSimpleName() + "发生变化");
        System.out.println("观察者1做出响应");
    }
}
