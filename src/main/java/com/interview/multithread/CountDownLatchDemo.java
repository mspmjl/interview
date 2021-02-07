package com.interview.multithread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Miaojiale on 2021/2/7.
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 1; i <= 5; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " 线程");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println("===========结束");
    }
}
