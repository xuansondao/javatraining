package com.xuansondao.lab7;

import java.awt.*;
import java.io.*;
import java.nio.channels.FileChannel;

public class FileNIOExample {
    public static void main(String[] args) {
        File sourceFile= new File("C:\\Temp2\\test1\\io_sample.txt");
        File desFile = new File(sourceFile.getParentFile(),"sample.txt");
        FileChannel srcChannel = null;
        FileChannel desChannel = null;

        try {
            srcChannel = new FileInputStream(sourceFile).getChannel();
            desChannel = new FileOutputStream(desFile).getChannel();
            srcChannel.transferTo(0, srcChannel.size(), desChannel);
            Desktop.getDesktop().open(sourceFile.getParentFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
