package com.xuansondao.lab8;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class DatagramServerSample implements Runnable {

    public DatagramServerSample() throws SocketException {
        //DatagramSocket socket = new DatagramSocket(4445);
        System.out.println("DATA server listerning....");

    }

    @Override
    public void run() {
        byte[] bytes = null;
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(4445);

            bytes = "Server say hello".getBytes();
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
            socket.receive(packet);
            System.out.println("From client : " + new String(packet.getData(), 0, packet.getLength()));

            socket.send(new DatagramPacket(bytes, bytes.length, packet.getAddress(), packet.getPort()));
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }


    }

    public static void main(String[] args) {
        try {
            new Thread(new DatagramServerSample()).start();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
