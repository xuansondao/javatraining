package com.xuansondao.lab2;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class CharaterExample {
    private static AtomicInteger countDigit(String value) {
//		int i = 0;
//		int counter = 0;
//		while(i < value.length())
//		{
//			char c = value.charAt(i);
//			if(Character.isDigit(c))
//				counter++;
//			i++;
//		}
        AtomicInteger counter = new AtomicInteger(0);
        IntStream stream = value.chars();
        stream.forEach(c ->{
            if(Character.isDigit(c)) counter.incrementAndGet();
        });
        return counter;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("there are : " + countDigit(args[0] ) + " digit in the text");
    }
}
