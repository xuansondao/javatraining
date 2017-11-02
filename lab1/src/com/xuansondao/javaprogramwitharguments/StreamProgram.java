package com.xuansondao.javaprogramwitharguments;

import java.util.Arrays;

public class StreamProgram {
    public static void main(String[] args) {
        System.out.println("length of arguments: " + args.length);
        Arrays.stream(args).forEach((String value) -> {
            System.out.println("Value is: " + value);
        });
    }
}
