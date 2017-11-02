package com.xuansondao.lab2;

import java.util.Calendar;
import java.util.Locale;

public class StringSwitchStatement {
    String getTypeOfDay(Calendar calendar) {
        String type = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, new Locale("vi"));
        switch (type) {
            case "Th 2":
                return "start of work week";
            case "Th 3":
            case "Th 4":
            case "Th 5":
                return "Mid week";
            case "Th 6":
                return "End of week";
            case "Th 7":
            case "CN":
                return "Weekend";
        }
        return "Unknown";
    }

    public static void main(String[] args) {
        StringSwitchStatement statement = new StringSwitchStatement();
        Calendar calendar = Calendar.getInstance();
        System.out.println("Today is " + statement.getTypeOfDay(calendar));
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + 1);
        System.out.println("Tomorow is " +statement.getTypeOfDay(calendar));
    }
}
