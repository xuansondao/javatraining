package com.xuansondao.lab7;

import java.awt.*;
import java.io.*;

public class RandomAccessExample {
    public static void main(String[] args) {
        File file = new File("C:" + File.separator + "Temp2" + File.separator + "test" + File.separator + "io_sample.txt");
        RandomAccessFile randomAccess = null;

        try {
            randomAccess = new RandomAccessFile(file, "rw");
            randomAccess.seek(9);
            byte[] bytes = new byte[4 * 102];
            int read = randomAccess.read(bytes);
            System.out.println(new String(bytes, 0, read, "utf8"));
            randomAccess.seek(file.length());
            randomAccess.write("\r\n".getBytes());
            randomAccess.writeChars("Hello Co Can");
            Desktop.getDesktop().open(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                randomAccess.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
