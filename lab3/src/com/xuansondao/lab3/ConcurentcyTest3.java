package com.xuansondao.lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ConcurentcyTest3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Integer[] values = {1, 3, 4, 2, 3, 6, 3, 3, 8};
        Collections.addAll(list, values);
        System.out.println("Before remove : size of list " + list.size());
//        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()){
//            if(iterator.next()==3)
//                iterator.remove();
//        }

//        list.removeIf(item->{
//            return item == 3;
//        });
        list.removeAll(Collections.singleton(3));
        System.out.println("After remove: size of list " + list.size());
    }
}
