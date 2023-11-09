package com.example.customer.utils;

public class FormatterUtil {
    public static String formatField(String field){
        return field.trim().replaceAll( "[ ]{2,}", " ").toUpperCase();
    }
}
