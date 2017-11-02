package com.xuansondao.lab7;

import java.io.*;

public class ObjectWriteExample {
    public static void main(String[] args) {
        File forder = new File("C:\\Temp2\\test1\\");
        ObjectOutputStream outputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(new File(forder,"my_object.txt"));
            outputStream = new ObjectOutputStream(fileOutputStream);
            //PrintMessage printMessage = null;
            outputStream.writeObject(new PrintMessage("Can noi doi"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
