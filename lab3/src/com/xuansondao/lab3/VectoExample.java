package com.xuansondao.lab3;

import java.util.Vector;

public class VectoExample {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(14);
        vector.add(7);
        vector.add(5);
        vector.add(12);
        System.out.println("size of vector = " + vector.size());
        System.out.println("Element at 2 = " + vector.get(2));
    }
}
