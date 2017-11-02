package com.xuansondao.lab7;

import java.io.File;

public class FileExample {
    public static void main(String[] args) {
        File file = new File("C:\\Temp");
//        if (file.isDirectory()){
//            System.out.println("This is folder");
//        }else {
//            System.out.println("This is file");
//        }
        System.out.println("This is " + (file.isDirectory() ? "Folder" : "File") + "!");
        File[] files = file.listFiles();
        for (File f : files
                ) {
            System.out.println(f.getName() + " : " + f.length() + " bytes");

        }
    }
}
