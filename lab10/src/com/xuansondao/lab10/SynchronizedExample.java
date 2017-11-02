package com.xuansondao.lab10;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class SynchronizedExample {
    public static void addData(List<Integer> list){
        IntStream.range(0,1000).forEach(index->{
            try{
                list.add(index);
            }catch (Exception exp){
                System.err.println(exp.toString());
            }
        });
    }

    public static void main(String[] args) {
        List<List<Integer>> values = new ArrayList<List<Integer>>();
        for (int  i = 0; i < 10; i++){
            List list = new ArrayList();
                new Thread(()->{addData(list);}).start();
                new Thread(()->{addData(list);}).start();
                values.add(list);
        }
        try {
            Thread.sleep(5*1000);
            values.forEach(list -> System.out.println("number items of list " + list.size()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
