package com.xuansondao.lab8;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class HttpHeaderExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.youtube.com/");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            System.out.println("http method: " + httpURLConnection.getRequestMethod());
            Map<String, List<String>> headers = httpURLConnection.getHeaderFields();
            BiConsumer<String, List<String>> header = (key, value) -> {
                System.out.println("Key" + key + " Values " + value);
            };
            headers.forEach(header);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
