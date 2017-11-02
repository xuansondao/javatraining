package com.xuansondao.lab3;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConcurentcyTest2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Integer[] values = {1, 3, 4, 2, 3, 6, 3, 3, 8};
        Collections.addAll(list, values);
        System.out.println("Before remove : size of list " + list.size());
        for (int i = 0; i < values.length; i++) {
            if (list.get(i) == 3)
                list.remove(i);
        }

        System.out.println("After remove: size of list " + list.size());
    }
}
