package com.xuansondao.lab2;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MessageFormatExample {
    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, dd MMMMM yyyy");
        String message = MessageFormat.format("Hello {0}! ToDay is {1}", args[0],
                dateFormat.format(Calendar.getInstance().getTime()));
        System.out.println(message);
    }
}
