package com.interview.multithread.queue;

import java.util.concurrent.SynchronousQueue;

/**
 * Created by Miaojiale on 2021/2/14.
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        SynchronousQueue synchronousQueue = new SynchronousQueue();
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+" put1");
                synchronousQueue.put("1");
                System.out.println(Thread.currentThread().getName()+" put2");
                synchronousQueue.put("2");
                System.out.println(Thread.currentThread().getName()+" put3");
                synchronousQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"ThreadA").start();

        new Thread(()->{
            try {
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName()+" take1");
                synchronousQueue.take();
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName()+" take2");
                synchronousQueue.take();
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName()+" take3");
                synchronousQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"ThreadB").start();
    }
}
