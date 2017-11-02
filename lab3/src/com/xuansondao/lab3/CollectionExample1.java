package com.xuansondao.lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CollectionExample1 {
    public static void main(String[] args) {
        Short[] values = {1,2,4,5,6,7,8,9};
        List<Short> list = new ArrayList<>();
        Collections.addAll(list, values);
        Collections.reverse(list);
        list.toArray(values);
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + ",");
        }
        System.out.println();
       short max = Collections.max(list, (o1, o2) -> {
           return -(o2 + o1);
       });
        System.out.println("Giá trị lớn nhất của mảng là: " + max);
        short min = Collections.min(list,(o1, o2) -> {
            return -(o2 + o1);
        });
        System.out.println("Giá trị nhỏ nhất của mảng là: " + min);
    }
}
