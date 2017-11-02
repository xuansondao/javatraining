package com.xuansondao.lab8;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class TestHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String message = "<html><h2> This is the respone</h2></html>";
        httpExchange.sendResponseHeaders(200,message.length());
        try{
            OutputStream out = httpExchange.getResponseBody();
            out.write(message.getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
