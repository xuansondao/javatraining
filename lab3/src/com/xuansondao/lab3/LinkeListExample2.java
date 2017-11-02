package com.xuansondao.lab3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LinkeListExample2 {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>(Arrays.asList(args));
        list.forEach(value -> {
            System.out.println(value);
        });
    }
}
