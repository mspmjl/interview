package com.interview.multithread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Miaojiale on 2021/1/30.
 */
class MyData {
//    int value;
    volatile int value;
    AtomicInteger atomicInteger = new AtomicInteger();
    void add() {
        this.value += 60;
    }
    void add1(){
        this.value += 1;
    }
}

public class VolatileDemo {

    public static void main(String[] args) {

        MyData myData = new MyData();
//        new Thread(() -> {
//            myData.add();
//            System.out.println(Thread.currentThread().getName() + "'s value : " + myData.value);
//        }, "ThreadA").start();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(Thread.currentThread().getName() + "'s value : " + myData.value);
        // 不保证原子性
        for (int i = 0; i < 200; i++) {
            new Thread(() -> {
                for (int j = 0; j < 2000; j++) {
                    myData.add1();
                    System.out.println(Thread.currentThread().getName() + "'s value : " + myData.value);
                }
            }, "Thread" + i).start();
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "'s value : " + myData.value);
    }
}
