package com.xuansondao.lab6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class InvokedAllExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newWorkStealingPool();
        List<CallableSample> callableSamples = new ArrayList<>(Arrays.asList(
                new CallableSample(),
                new CallableSample(),
                new CallableSample()
        )) ;
        Stream stream,result;
        try {
            stream = executorService.invokeAll(callableSamples).stream();
            result = stream.map(future-> {
                try {
                    return ((Future)future).get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                return future;
            });
            Object[] results = result.toArray(Integer[]::new);
            Arrays.stream(results).forEach(System.out::println);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("------------------->" + executorService.invokeAll(callableSamples));
    }
}
