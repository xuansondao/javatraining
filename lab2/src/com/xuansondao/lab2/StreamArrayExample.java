package com.xuansondao.lab2;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;


public class StreamArrayExample {
    public static void main(String[] args) {
        Integer[] values = {2, 7, 8, 51, 4, 6, 9, 11, 3};
        Arrays.sort(values, (Integer o1, Integer o2) -> {
            return o2 - o1;
        });
        for (int i = 0; i < values.length; i++) {
            System.out.printf("%4d", values[i]);
        }



        Optional<Integer> max;
        Stream<Integer> stream = Arrays.stream(values);
        Consumer<Integer> c = (value) -> {
            System.out.println(value);
        };
        stream.forEach(c);
        max = stream.max((o1, o2) -> {
            return -(o2 - o1);
        });

        System.out.println("\nGiá trị lớn nhất là: " + max.get());
        Predicate<Integer> predicate = (value)->{ return  value > 5;};
        Stream<Integer> older = stream.filter(predicate);
        older.forEach((Integer value)-> System.out.println(value));

    }
}
