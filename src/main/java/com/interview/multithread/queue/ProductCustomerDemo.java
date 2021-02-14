package com.interview.multithread.queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Miaojiale on 2021/2/14.
 */
class shareData {
    int number = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    void increase() throws InterruptedException {
        try {
            lock.lock();
            while (number != 0) {
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + " increase" + "number : " + number);
            condition.signalAll();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    void decrease() throws InterruptedException {
        try {
            lock.lock();
            while (number == 0) {
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + " decrease");
            condition.signalAll();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }
}

public class ProductCustomerDemo {
    public static void main(String[] args) {
        shareData shareData = new shareData();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    shareData.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "thread increase " + i).start();
            new Thread(() -> {
                try {
                    shareData.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "thread decrease" + i).start();
        }
    }
}
