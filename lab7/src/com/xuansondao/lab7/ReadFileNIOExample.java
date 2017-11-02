package com.xuansondao.lab7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadFileNIOExample {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        FileChannel fileChannel = null;
        File forder = new File("C:\\Temp2\\test1\\");



        try {
            fileInputStream = new FileInputStream(new File(forder, "my_object.txt"));
            fileChannel = fileInputStream.getChannel();
            long size = fileChannel.size();
            ByteBuffer buffer = ByteBuffer.allocate((int) size);
            fileChannel.read(buffer);
            buffer.rewind();
            System.out.println(new String(buffer.array(),"utf8"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fileChannel != null){
                try {
                    fileChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
