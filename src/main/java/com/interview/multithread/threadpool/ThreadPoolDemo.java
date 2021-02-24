package com.interview.multithread.threadpool;

import java.util.concurrent.*;

/**
 * Created by Miaojiale on 2021/2/19.
 */
public class ThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        ExecutorService executorService = Executors.newSingleThreadExecutor(); // 一池一个线程
//        ExecutorService executorService = Executors.newCachedThreadPool(); // 一池N个线程
//        for (int i = 0; i < 20; i++) {
//            executorService.execute(() -> {
//                System.out.println(Thread.currentThread().getName());
//            });
//            Thread.sleep(1000);
//        }
//        executorService.shutdown();
        System.out.println(Runtime.getRuntime().availableProcessors());
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
                5, 1, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());
        for (int i = 1; i <= 10; i++) {
            threadPoolExecutor.execute(()->{
                System.out.println(Thread.currentThread());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        threadPoolExecutor.shutdown();
    }
}
