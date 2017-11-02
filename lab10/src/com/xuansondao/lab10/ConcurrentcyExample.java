package com.xuansondao.lab10;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentcyExample {

    static Lock lock = new ReentrantLock();

    public synchronized static void addData(List list) {
        while (true) {
            //lock.lock();
            int random = (int) (Math.random() * 100);
            list.add(random);
            System.out.println("add new data: " + random);
            if (random == 0) break;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //lock.unlock();
        }
    }

    static boolean flag = true;

    public synchronized static void printData(List list) {
        while (flag) {

            try {
                System.out.println("============");
                list.forEach(value -> System.out.println("value = " + value));
                flag = false;
                Thread.sleep(100l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //lock.unlock();
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        new Thread(() -> {
            addData(list);
        }).start();
        new Thread(() -> {
            printData(list);
        }).start();
    }
}
