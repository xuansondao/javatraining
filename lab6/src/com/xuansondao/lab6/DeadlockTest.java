package com.xuansondao.lab6;

public class DeadlockTest {
    public static void main(String[] args) {
        Object object1 = new Object();
        Object object2 = new Object();


        DeadlockDemo thread1 = new DeadlockDemo(object1,object2);
        DeadlockDemo thread2 = new DeadlockDemo(object2,object1);
        thread1.start();
        thread2.start();
    }
}
