package com.xuansondao.lab6;

import com.sun.net.httpserver.Authenticator;

import java.util.concurrent.*;

public class FeatureExampleTest {
    public static void main(String[] args) {
        CallableSample callableSample = new CallableSample();
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Integer> future = executorService.submit(callableSample);
        System.out.println("Future done ? " + future.isDone());
        try {
//           Integer result = future.get();
            Integer result = future.get(3, TimeUnit.SECONDS);
            System.out.println("Future Done ? " + future.isDone() + "-result = " + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
