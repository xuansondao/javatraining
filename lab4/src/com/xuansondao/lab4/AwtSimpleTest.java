package com.xuansondao.lab4;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AwtSimpleTest {
    public static void main(String[] args) {
        AwtExample1 screen =new AwtExample1();
        screen.setSize(400, 500);
        screen.setVisible(true);

        screen.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
    }
}
