package com.jiaos.gcz;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @（#）:Observable.java
 * @description:
 * @author: jiaosen 2017/10/25
 * @version: Version 1.0
 */
public class Observable {
    List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void change(){
        System.out.println("我是被观察者，我已经发生变化");
        notifyObservers();
    }

    public void notifyObservers(){
        for(Observer observer : observers){
            observer.update(this);
        }
    }

    @Test
    public void testGCZ(){
        Observable observable = new Observable();
        observable.addObserver(new ConcreteObserver1());
        observable.addObserver(new ConcreteObserver2());

        observable.change();
    }
}
