package com.xuansondao.lab3;

import java.util.Hashtable;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        Map<Integer, String> map = new Hashtable<>();
        map.put(3, "Nguyễn Văn Nam");
        map.put(2, "Đào Xuân Sơn");
        map.put(1, "Lê Công Vũ");
        map.put(4, "Vũ Đức chính");
        System.out.println(map.get(3));
        map.put(3, "Bùi Anh Văn");
        System.out.println(map.get(3));

    }
}
