package com.xuansondao.lab3;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class CollectionOperation {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(4, 7, 1, 3, 8, 9, 2, 6, 10));
//        Comparator<Integer> comparator = Integer::compare;
//        Collections.sort(list, comparator);
//        for (Integer element : list
//                ) {
//            System.out.print(element + "    ");
//        }
//        list.stream().filter(v->v>5).forEach(v->{
//            System.out.print(v + "    ");
//        });
//        Integer[] values = list.stream().filter(v->v>5).toArray(size->new Integer[size]);
//        Arrays.stream(values).forEach(v->{
//            System.out.print(v + "    ");
//        });

//        int sum = list.stream().reduce(0,(x, y)->x + y);
//        int sum = list.stream().reduce(0, Integer::sum);
//        System.out.println(sum);
//
//        Collector<Integer,?,IntSummaryStatistics> collectors = Collectors.summarizingInt(Integer::intValue);
//        IntSummaryStatistics summaryStatistics = list.stream().collect(collectors);
//        System.out.println("total = " + summaryStatistics);
//        System.out.println("overage = " + summaryStatistics.getAverage());
//
//        Consumer<Integer> myConsumer = n->{
//            System.out.println("user input value = " + n);
//            if(n<5){
//                System.out.println("Invalid value");
//                return;
//            }
//            list.add(n);
//            System.out.println(values);
//            list.forEach(x-> System.out.println(x + '-'));
//        };
//        myConsumer.accept(12);
//
//        Scanner scanner = new Scanner(System.in);
//        while (true){
//            System.out.println("Please input a number: ");
//            int value = scanner.nextInt();
//            myConsumer.accept(value);
//            System.out.println();
//        }

        Predicate<Integer> tester = (Integer v)->v>5;
        Consumer<Integer> myConsumer = n->list.add(n);
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Please input a number: ");
            int value = scanner.nextInt();
            if (value < 0)break;
            if(tester.test(value))
            myConsumer.accept(value);

        }
        list.forEach(v-> System.out.print(v + "-"));


    }
}
