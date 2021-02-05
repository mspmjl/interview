package com.interview.multithread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Miaojiale on 2021/2/5.
 */
class Demo {
    volatile Map<String, String> map = new HashMap<>();
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    void put(String s1, String s2) {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " come in put");
            map.put(s1, s2);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "  put end");
            lock.writeLock().unlock();
        }
    }

    void get(String s) {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " come in get");
            System.out.println("result: " + map.get(s));
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
            System.out.println(Thread.currentThread().getName() + "  come end");
        }
    }
}

public class WriteReadLockDemo {
    public static void main(String[] args) throws InterruptedException {
        Demo demo = new Demo();
        for (int i = 0; i < 5; i++) {
            final int num = i;
            new Thread(() -> {
                demo.put(num + "", num + "");
            }, num + "").start();
        }

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                demo.get(finalI + "");
            }, finalI + "").start();
        }
    }
}
