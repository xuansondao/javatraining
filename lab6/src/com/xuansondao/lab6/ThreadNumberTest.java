package com.xuansondao.lab6;

import java.util.concurrent.TimeUnit;

public class ThreadNumberTest {
    public static void main(String[] args) {
        PrintNumber number = new PrintNumber();
        Thread thread = new Thread(number);
        thread.setName("HaNoi_Thread");
        thread.start();
        PrintNumber number1 = new PrintNumber();
        Thread thread1 = new Thread(number1);
        thread1.setName("NamDinh_Thread");
        thread1.start();
//        try {
//            Thread.currentThread().join();
//            while (thread.isAlive()){
//                if(number.getNumber()%10 == 0){
//                    number.setAlive(false);
//                }
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        try {
//            Thread.currentThread().join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        thread.setDaemon(true);
//        thread.start();
//        System.out.println("Main Thread say hello");
//        System.out.println("Main Thread say goobye");

    }
}
