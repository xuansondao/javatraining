package com.xuansondao.lab7;



import java.io.*;

public class FileOutputExample {
    public static void main(String[] args) {
        File file = new File("C:" + File.separator + "Temp" + File.separator + "hanoijava.txt");
        FileOutputStream outputStream = null;
        FileInputStream inputStream = null;

        try {
            outputStream = new FileOutputStream(file);
            byte[] bytes = "Hello Ha Noi Java Class".getBytes();
            outputStream.write(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (outputStream != null)
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

        try {
            inputStream = new FileInputStream(file);
            inputStream.read();
            byte[] bytes = new byte[4*1024];
            int read = -1;
            StringBuilder builder =new StringBuilder("");
            while ((read = inputStream.read(bytes)) != -1){
                builder.append(new String(bytes,0, read));
            }
            System.out.println("["+builder+"]");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
