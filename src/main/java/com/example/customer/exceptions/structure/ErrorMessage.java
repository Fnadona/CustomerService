package com.example.customer.exceptions.structure;

public abstract class ErrorMessage {

    public static final String BLANK_NAME_MESSAGE = "The name is required.";
    public static final String INVALID_NAME_FORMAT_MESSAGE = "There are invalid character in name (use only letters, letters with accents and numbers).";
    public static final String NULL_ADDRESS_MESSAGE = "The address is required.";
    public static final String NULL_DOCUMENT_TYPE_MESSAGE = "The document type is required.";
    public static final String ENUM_VALIDATION_MESSAGE = "Enum is invalid.";
    public static final String INVALID_DOCUMENT_TYPE_MESSAGE = "Document type is invalid.";
    public static final String BLANK_DOCUMENT_CODE_MESSAGE = "The document code is required.";
    public static final String BLANK_EMAIL_MESSAGE = "The email is required.";
    public static final String INVALID_EMAIL_FORMAT_MESSAGE = "The email is invalid.";
    public static final String INVALID_PHONE_FORMAT_MESSAGE = "There must be only numbers in phone.";
    public static final String INVALID_PHONE_LENGTH_MESSAGE = "The phone number must have at least 9 digits and at most 15 digits.";
    public static final String BLANK_STREET_MESSAGE = "The street is required.";
    public static final String BLANK_NUMBER_MESSAGE = "The number is required.";
    public static final String BLANK_DISTRICT_MESSAGE = "The district is required.";
    public static final String BLANK_CITY_MESSAGE = "The city is required.";
    public static final String BLANK_COUNTRY_MESSAGE = "The country is required.";
    public static final String BLANK_POSTAL_CODE_MESSAGE = "The postal code is required.";
    public static final String INVALID_STREET_FORMAT_MESSAGE = "There are invalid character in street (use only letters, letters with accents and numbers).";
    public static final String INVALID_COMPLEMENT_FORMAT_MESSAGE = "There are invalid character in complement (use only letters, letters with accents and numbers).";
    public static final String INVALID_DISTRICT_FORMAT_MESSAGE = "There are invalid character in district (use only letters, letters with accents and numbers).";
    public static final String INVALID_CITY_FORMAT_MESSAGE = "There are invalid character in city (use only letters, letters with accents and numbers).";
    public static final String INVALID_COUNTRY_FORMAT_MESSAGE = "There are invalid character in country (use only letters, letters with accents and numbers).";
    public static final String INVALID_NUMBER_FORMAT_MESSAGE = "There must be only numbers in field number.";
    public static final String INVALID_POSTAL_CODE_FORMAT_MESSAGE = "There must be only numbers in postal code.";
    public static final String PERSISTENCE_ERROR_MESSAGE = "It wasn't possible to persist the customer";
    public static final String PARSE_ERROR_MESSAGE = "It wasn't possible to parse the data";
    public static final String CUSTOMER_NOT_FOUND_MESSAGE = "Customer not found";
    public static final String COMPLETING_INVALID_FIELD_MESSAGE = "Field filled in wrong";

}
