package com.xuansondao.lab4;

import javafx.scene.control.CheckBox;
import java.awt.*;


public class CheckBoxExample extends Frame {
    public CheckBoxExample(){
        CheckBox checkBox1 = new CheckBox("Lựa chọn 1");
        //checkBox1.setFont(new Font("Arial", Font.BOLD, 14));
        //add(checkBox1);
        final Checkbox checkbox2 = new Checkbox("Check box 2");
        add(checkbox2);
        checkbox2.addItemListener(e -> {
            System.out.println("value2 = " + checkbox2.getState());
        });

    }
}
