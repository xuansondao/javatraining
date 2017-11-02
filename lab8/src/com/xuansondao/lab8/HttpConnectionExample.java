package com.xuansondao.lab8;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class HttpConnectionExample {
    public static void main(String[] args) {
        Path path = null;
        InputStream inputStream = null;
        OutputStream outputStream =null;
        try {
            URL url = new URL("https://www.youtube.com/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            path = Paths.get("C:/Users/xuanson/Desktop/test.html");
             inputStream= connection.getInputStream();
             outputStream= Files.newOutputStream(path, StandardOpenOption.CREATE.APPEND);
            byte[] bytes = new byte[1024 * 1024 * 1024];
            int read;
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                Desktop.getDesktop().open(path.toFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
