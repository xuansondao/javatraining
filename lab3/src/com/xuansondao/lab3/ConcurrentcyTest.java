package com.xuansondao.lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConcurrentcyTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Integer[] values = {1, 3, 4, 2, 3, 6, 3, 3, 8};
        Collections.addAll(list, values);
        System.out.println("Before remove : size of list " + list.size());
        for (Integer v : list
                ) {
            if (v == 3)
                list.remove(v);

        }
        System.out.println("After remove: size of list " + list.size());
    }
}
