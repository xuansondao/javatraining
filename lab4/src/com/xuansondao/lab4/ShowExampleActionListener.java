package com.xuansondao.lab4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ShowExampleActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        AwtExample1 screen = new AwtExample1();
        screen.setSize(250, 400);
        screen.setVisible(true);

        screen.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // TODO Auto-generated method stub
                super.windowClosing(e);
                System.exit(1);
            }
        });
    }
}
