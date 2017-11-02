package com.xuansondao.lab8;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SocketClientExample {
    public static void main(String[] args) {
        DataInputStream inputStream = null;
        DataOutputStream outputStream = null;
        Socket socket = null;
        try {
            socket = new Socket("localhost", 8888);
            System.out.println("Client start sending....");
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.writeUTF("Hello Server");
            System.out.println("Server Say: " + inputStream.readUTF());
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
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
