package com.example.customer.utils;

public abstract class RegexUtils {
    public static final String LETTER_REGEX = "^([a-zA-Z]|[à-ü]|[À-Ü]| )*$";
    public static final String NUMBER_FIELD_REGEX = "^[0-9]+$";
    public static final String LETTER_AND_NUMBER_REGEX = "^([a-zA-Z]|[à-ü]|[À-Ü]|[0-9]|º|ª| )*$";
}
