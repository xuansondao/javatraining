package com.xuansondao.lab6;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Map<String, String> map = new HashMap<>();
        ReadWriteLock lock = new ReentrantReadWriteLock();
//        executorService.submit(()->{
//            System.out.println("start Writing");
//            lock.writeLock().lock();
//            try {
//                TimeUnit.SECONDS.sleep(10);
//                map.put("foo", "bar");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }finally {
//                lock.writeLock().unlock();
//                System.out.println("end writing");
//            }
//        });
        Runnable readTeask = ()->{
            System.out.println("start Writing");
            lock.readLock().lock();
            try {
                TimeUnit.SECONDS.sleep(10);
                map.put("foo", "bar");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.readLock().unlock();
                System.out.println("end writing");
            }
        };
        executorService.submit(readTeask);
        executorService.submit(readTeask);

    }
}
