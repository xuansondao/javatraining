package com.xuansondao.lab4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AwtExample1 extends Frame {
    private List list;
    public AwtExample1() {
        //setLayout(new FlowLayout());
        setLayout(new BorderLayout());
        final  TextField textField = new TextField();
        add(textField, BorderLayout.PAGE_START);
        list = new List(4, true);
        IntStream.range(0,10).forEach(i->{
            list.add("Item " + i);
        });
        add(list,BorderLayout.CENTER);
        Button pushButton = new Button("press me");
        add(pushButton, BorderLayout.LINE_END);
        pushButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // AwtExample1.this.setTitle(textField.getText());
                //System.out.println(textField.getText());

                Supplier<StringBuilder> supplier = StringBuilder::new;
                BiConsumer<StringBuilder,String>consumer = (builder, value)->{
                    if(builder.length()>0)builder.append("; ");
                    builder.append(value);
                };

                BinaryOperator<StringBuilder> operator = StringBuilder::append;
                Function<StringBuilder, String>finisher = StringBuilder::toString;

                String[] values = list.getSelectedItems();
                Collector<String, StringBuilder, String> collector =
                        Collector.of(supplier,consumer, operator, finisher);
                Arrays.stream(values).collect(Collectors.joining(","));
                textField.setText(Arrays.stream(values).collect(collector));
            }
        });

        MenuBar menuBar = new MenuBar();
        setMenuBar(menuBar);

        Menu menu = new Menu("File");
        menuBar.add(menu);

        MenuItem menuItem = new MenuItem("Exit", new MenuShortcut('X'));
        menu.add(menuItem);
        menuItem.addActionListener(e->{
            System.exit(1);
        });

    }


}
