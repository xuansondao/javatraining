package com.xuansondao.lab9;

public class RunableTest {
    public static void main(String[] args) {
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName() + "Say hello java class");
//            }
//        };
//        new Thread(runnable).start();
//        Runnable runnable = ()->{
//                System.out.println(Thread.currentThread().getName() + "Say hello java class");
//        };
//        new Thread(runnable).start();
//        new Thread(() -> {
//            System.out.println(Thread.currentThread().getName() + "Say hello java class");
//        }).start();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "Say hello java class");
            System.out.println("1 + 1 = " + (1 + 1));
        }).start();
    }
}
