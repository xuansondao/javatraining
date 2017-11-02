package com.xuansondao.lab6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ThreadpoolTest {
    public static void main(String[] args) {
        PrintNumber number = new PrintNumber();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        IntStream.range(0,6).forEach(i->executorService.submit(number));
    }
}
