package com.interview.multithread;

/**
 * Created by Miaojiale on 2021/1/30.
 */
class MyData {
    int value;

    void add() {
        this.value += 60;
    }
}

public class VolatileDemo {

    public static void main(String[] args) {
        MyData myData = new MyData();
        new Thread(() -> {
            myData.add();
            System.out.println(Thread.currentThread().getName() + "'s value : " + myData.value);
        }, "ThreadA").start();
        System.out.println(Thread.currentThread().getName() + "'s value : " + myData.value);

    }
}
