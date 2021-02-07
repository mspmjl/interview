package com.interview.multithread;

import java.util.concurrent.Semaphore;

/**
 * Created by Miaojiale on 2021/2/7.
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " 抢到");
                    Thread.sleep(50);
                    System.out.println(Thread.currentThread().getName() + " 结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}
