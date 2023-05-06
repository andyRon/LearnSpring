package com.andyron.spring6.javai18n;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author andyron
 **/
public class TestJavaI18n {
    public static void main(String[] args) {
        ResourceBundle bundle1 = ResourceBundle.getBundle("messages", new Locale("zh", "CH"));
        System.out.println(bundle1.getString("test"));

        ResourceBundle bundle2 = ResourceBundle.getBundle("messages", new Locale("en", "GB"));
        System.out.println(bundle2.getString("test"));
    }
}
