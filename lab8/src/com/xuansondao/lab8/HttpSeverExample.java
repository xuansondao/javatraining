package com.xuansondao.lab8;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class HttpSeverExample {
    public static void main(String[] args) {
        try {
            TestHandler testHandler = new TestHandler();
            HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
            server.createContext("/test",new TestHandler());
            server.setExecutor(Executors.newFixedThreadPool(5));
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
