package com.xuansondao.lab8;


import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.youtube.com/");
            URLConnection connection = url.openConnection();
            InputStream stream = connection.getInputStream();
            int read ;
            byte[]bytes = new byte[1024*1024*1024];
            while ((read = stream.read(bytes)) != -1){
                System.out.print(new String(bytes, 0, read));
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
