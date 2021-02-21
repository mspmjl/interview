package com.interview.multithread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Miaojiale on 2021/2/19.
 */
public class ThreadpoolDemo {
    public static void main(String[] args) throws InterruptedException {
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        ExecutorService executorService = Executors.newSingleThreadExecutor(); // 一池一个线程
        ExecutorService executorService = Executors.newCachedThreadPool(); // 一池N个线程
        for (int i = 0; i < 20; i++) {
            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });
//            Thread.sleep(1000);
        }
        executorService.shutdown();
    }
}
