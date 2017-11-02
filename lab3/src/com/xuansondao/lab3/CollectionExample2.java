package com.xuansondao.lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionExample2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String[] names = {"Sơn", "Khánh", "Thủy", "Bình"};
        Collections.addAll(list, names);
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + "    ");
        }
        System.out.println();
        System.out.println("Vị trí thứ: " + Collections.binarySearch(list,"Khánh"));

    }
}
