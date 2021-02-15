package com.interview.multithread.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Miaojiale on 2021/2/14.
 */
class shareRecourse {
    volatile boolean flag = true;
    BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(10);
    AtomicInteger atomicInteger = new AtomicInteger();

    void stop() {
        flag = false;
    }

    void myProd() throws InterruptedException {
        String str;
        boolean offer;
        while (flag) {
            str = atomicInteger.incrementAndGet() + "";
            offer = blockingQueue.offer(str, 1, TimeUnit.SECONDS);
            if (offer) {
                System.out.println(Thread.currentThread().getName() + "生产成功 " + str);
            } else {
                System.out.println(Thread.currentThread().getName() + "生产失败 ");
            }
            Thread.sleep(1000);
        }
        System.out.println("===========结束===========");
    }

    void consumer() throws InterruptedException {
        String str;
        while (flag) {
            str = blockingQueue.poll(1, TimeUnit.SECONDS);
            if (str != null) {
                System.out.println(Thread.currentThread().getName() + "消费成功 " + str);
            }
        }
    }
}


public class ProductCustomerQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        shareRecourse shareData = new shareRecourse();
        new Thread(() -> {
            try {
                shareData.myProd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "prod").start();
        new Thread(() -> {
            try {
                shareData.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "consumer").start();
        Thread.sleep(10000);
        shareData.stop();
    }
}
