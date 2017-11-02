package com.xuansondao.lab3;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(3, "Nguyễn Văn Nam");
        map.put(2, "Đào Xuân Sơn");
        map.put(1, "Lê Công Vũ");
        map.put(4, "Vũ Đức chính");
//        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
//        while (iterator.hasNext()){
//            Map.Entry<Integer, String> entry = iterator.next();
//            System.out.println(entry.getKey() + ":" + entry.getValue());
//        }
        map.descendingKeySet().forEach(key->{
            System.out.println("KEY = " + key + " value = " +map.get(key));
        });
    }
}
