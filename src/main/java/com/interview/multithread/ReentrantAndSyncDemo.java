package com.interview.multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Miaojiale on 2021/2/14.
 */
class shareData {
    int number = 1;
    Lock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();

    void print1() throws InterruptedException {
        lock.lock();
        try {
            while (number != 1) {
                c1.await();
            }
            for (int i = 1; i <= 1; i++) {
                System.out.println(Thread.currentThread().getName() + "打印第" + i + "次");
            }
            number = 2;
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void print2() throws InterruptedException {
        lock.lock();
        try {
            while (number != 2) {
                c2.await();
            }
            for (int i = 1; i <= 2; i++) {
                System.out.println(Thread.currentThread().getName() + "打印第" + i + "次");
            }
            number = 3;
            c3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    void print3() throws InterruptedException {
        lock.lock();
        try {
            while (number != 3) {
                c3.await();
            }
            for (int i = 1; i <= 3; i++) {
                System.out.println(Thread.currentThread().getName() + "打印第" + i + "次");
            }
            number = 1;
            c1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}


public class ReentrantAndSyncDemo {
    public static void main(String[] args) {
        shareData shareData = new shareData();
        new Thread(() -> {
            try {
                for (int i = 0; i < 2; i++) {
                    shareData.print1();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "print1 ").start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 2; i++) {
                    shareData.print2();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "print2 ").start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 2; i++) {
                    shareData.print3();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "print3 ").start();
    }
}
