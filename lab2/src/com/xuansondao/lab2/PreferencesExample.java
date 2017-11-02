package com.xuansondao.lab2;

import java.util.prefs.Preferences;

public class PreferencesExample {
    public static void main(String[] args) {
        Preferences preferences = Preferences.userNodeForPackage(PreferencesExample.class);
        System.out.println("Old value = " + preferences.get("data","No Value"));
        preferences.put("data1", "value" + System.currentTimeMillis());
        System.out.println("New value = " + preferences.get("data1", "No Value"));

    }
}
