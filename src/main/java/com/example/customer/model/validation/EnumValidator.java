package com.example.customer.model.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EnumValidator implements ConstraintValidator<EnumValidation, String> {
    private List<String> acceptedValues;

    @Override
    public void initialize(EnumValidation annotation) {
        this.acceptedValues = Stream.of(annotation.enumClass().getEnumConstants())
                .map(Enum::name)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        return acceptedValues.contains(value.toUpperCase());
    }
}

