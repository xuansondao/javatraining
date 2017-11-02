package com.xuansondao.lab6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LockSample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newWorkStealingPool(4);
        CallableSample sample = new CallableSample();
        List<CallableSample> list = new ArrayList<>(Arrays.asList(sample, sample, sample, sample));
        try {
            executorService.invokeAll(list);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
