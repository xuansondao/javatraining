package com.xuansondao.lab9;

import javax.swing.*;
import java.awt.*;

public class AWTListenerExample {
    public static void main(String[] args) {
        Frame screen = new Frame();

        Button button = new Button("Pressme");
        screen.add(button);

//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(null,"Welcome to java by example",
//                        "Java Sample", JOptionPane.INFORMATION_MESSAGE);
//            }
//
//        });
        button.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Welcome to java by example",
                    "Java Sample", JOptionPane.INFORMATION_MESSAGE);
        });
        screen.setSize(250, 400);
        screen.setVisible(true);
        screen.addWindowListener((WindowClosing)(e)->System.exit(1));
    }
}
