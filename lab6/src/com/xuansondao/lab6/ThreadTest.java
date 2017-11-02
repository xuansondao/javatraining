package com.xuansondao.lab6;

public class ThreadTest {
    public static void main(String[] args) {
       // PrintMessage message = new PrintMessage("Say hello to everyone");
        new Thread(new PrintMessage("Say Hello to everyone")).start();
        new Thread(new PrintMessage("Say Hello to everyone")).start();

    }
}
