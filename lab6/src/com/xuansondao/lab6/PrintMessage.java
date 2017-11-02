package com.xuansondao.lab6;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class PrintMessage implements Runnable {
    private String message;

    public PrintMessage(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        String [] elements =    message.split(" ");
        Arrays.stream(elements).forEach(ele->{

            try {
                System.out.println(Thread.currentThread().getName() + "print" + ele);
                //TimeUnit.SECONDS.sleep(1);
                Thread.sleep((int)(Math.random()*3)*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
