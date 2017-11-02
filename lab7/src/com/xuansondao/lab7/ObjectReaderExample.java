package com.xuansondao.lab7;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ObjectReaderExample {
    public static void main(String[] args) {
        ObjectInputStream inputStream = null;
        File forder = new File("C:\\Temp2\\test1\\");
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(new File(forder, "my_object.txt"));
            inputStream = new ObjectInputStream(fileInputStream);
            Object object = inputStream.readObject();
            Method method = object.getClass().getMethod("run", new Class[0]);
            method.invoke(object, new Object[0]);



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
