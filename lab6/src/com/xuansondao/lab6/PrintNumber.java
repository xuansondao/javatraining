package com.xuansondao.lab6;



public class PrintNumber implements Runnable {
    private Integer number = new Integer(1);
    //private boolean alive = true;

    public Integer getNumber() {
        return number;
    }

//    public void setAlive(boolean alive) {
//        this.alive = alive;
//    }

    @Override
    public void run() {
        Thread current = Thread.currentThread();
        synchronized (number){
            while (number < 30) {

                try {
                    number++;
                    System.out.println(current.getName() + " number is \"" + number + "\"");
                    Thread.sleep(1000);
                    if (number%10 == 0) break;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(current.getName() + " is stopped!!!");
            }
        }


    }
}
