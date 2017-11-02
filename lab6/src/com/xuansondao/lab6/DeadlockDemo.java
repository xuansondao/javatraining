package com.xuansondao.lab6;

import java.util.concurrent.locks.Lock;

public class DeadlockDemo extends Thread{
    private Object lock1;
    private Object lock2;

    public DeadlockDemo(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        synchronized (lock1){
            System.out.println(new Thread().getName() + ": Holding" + lock1 + "...");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(new Thread().getName() + ": Waiting for " + lock2 + "...");
            synchronized (lock2){
                System.out.println(new Thread().getName() + "--------->" + lock1 + ": " + lock2 + "...");
            }
        }
    }
}
