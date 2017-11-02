package com.xuansondao.lab7;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class LockFileNIOExample {
    public static void main(String[] args) {
        File file = new File("C:\\Temp2\\test1\\io_sample.txt");
        try {
            RandomAccessFile accessFile = new RandomAccessFile(file,"rw");
            FileChannel channel  = accessFile.getChannel();
            FileLock lock = channel.tryLock(0,Long.max(5,8), false);
            Desktop.getDesktop().edit(file);
            Thread.sleep(5*1000l);
            lock.release();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
