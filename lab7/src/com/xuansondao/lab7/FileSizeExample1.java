package com.xuansondao.lab7;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class FileSizeExample1 {
    private static long getSize(File file) {
        if (file.isFile()) return file.length();
        //File[] files = file.listFiles();
       // int length = 0;
        AtomicInteger length = new AtomicInteger();
        length.set(0);
        Arrays.stream(file.listFiles()).forEach(file1 -> {
            length.getAndSet((int) (length.longValue() + (file1.isDirectory() ? getSize(file1) : file1.length())));
        });
//        for (int i = 0; i < files.length; i++) {
//            if (files[i].isDirectory()) {
//                length += getSize(files[i]);
//                continue;
//            }
//            length += files[i].length();
//        }
        return length.longValue();
    }

    public static void main(String[] args) {
        File file = new File("C:\\Temp");
        System.out.println("Size" + getSize(file)/(1024*1024) + "MB");
    }
}
