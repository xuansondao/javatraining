package com.xuansondao.lab8;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerExample {
    DataInputStream inputStream = null;
    DataOutputStream outputStream = null;
    Socket socket = null;

    public SocketServerExample(int port) {

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("SERVER Listerning....");
            while (true){
                socket = serverSocket.accept();
                new Thread(
                        ()->{
                            try {
                                inputStream = new DataInputStream(socket.getInputStream());
                                System.out.println("ClienSay: " + inputStream.readUTF());
                                outputStream = new DataOutputStream(socket.getOutputStream());
                                outputStream.writeUTF("i'm socket server");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                ).start();
            }

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

    public static void main(String[] args) {
        SocketServerExample serverExample  = new SocketServerExample(8888);
    }
}
