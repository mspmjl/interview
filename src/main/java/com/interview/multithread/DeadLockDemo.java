package com.interview.multithread;

/**
 * Created by Miaojiale on 2021/2/24.
 */
class TestCase implements Runnable {
    String lockA;
    String lockB;

    public TestCase(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread() + lockA + "希望读取" + lockB);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                System.out.println(Thread.currentThread() + lockB + "希望读取" + lockA);
            }
        }
    }
}

public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new TestCase(lockA, lockB), "ThreadA").start();
        new Thread(new TestCase(lockB, lockA), "ThreadB").start();
    }
}
