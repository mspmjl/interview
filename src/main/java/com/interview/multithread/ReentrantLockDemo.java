package com.interview.multithread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Miaojiale on 2021/2/3.
 */
public class ReentrantLockDemo {
    public static void main(String[] args) {
//        Phone phone = new Phone();
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                phone.sendEmail();
//            }).start();
//        }
        Persion p = new Persion();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                p.run();
            }).start();

        }
    }
}

class Phone {
    synchronized void sendEmail() {
        System.out.println("================= Thread" + Thread.currentThread().getId() + "  sendEmail");
        playGame();
    }

    synchronized void playGame() {
        System.out.println("================= Thread" + Thread.currentThread().getId() + "  playGame");
    }
}

class Persion {
    Lock lock = new ReentrantLock();

    void run() {
        lock.lock();
        System.out.println("================= Thread" + Thread.currentThread().getId() + "  run");
        eat();
        lock.unlock();
    }

    void eat() {
        lock.lock();
        System.out.println("================= Thread" + Thread.currentThread().getId() + "  eat");
        lock.unlock();
    }
}