package com.xuansondao.lab7;

import java.awt.*;
import java.io.*;

public class ReaderWriterExample {
    public static void main(String[] args) {
        File file = new File("C:" + File.separator + "Temp2" + File.separator + "test" + File.separator + "io_sample.txt");
        FileWriter writer = null;
        FileReader reader = null;
        try {
            writer = new FileWriter(file);
            writer.write("\r\n");
            writer.write("Đào xuân sơn");
            Desktop.getDesktop().open(file);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            reader = new FileReader(file);
            char[] buffer = new char[4*1024];
            int read = -1;
            StringBuilder builder = new StringBuilder("");
            while ((read = reader.read(buffer))!= -1){
                builder.append(buffer,0,read);
            }
            System.out.println(builder);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
