package com.interview.multithread;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Miaojiale on 2021/2/5.
 */
public class SpinLockDemo {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "come in Lock function");
        while (!atomicReference.compareAndSet(null, thread)) {

        }
    }

    public void unLock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + " come in unLock function");
        atomicReference.compareAndSet(thread, null);
    }

    public static void main(String[] args) throws InterruptedException {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(() -> {
            spinLockDemo.myLock();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.unLock();
        }, "A").start();
        Thread.sleep(1000);
        new Thread(() -> {
            spinLockDemo.myLock();
            spinLockDemo.unLock();
        }, "B").start();
    }
}
