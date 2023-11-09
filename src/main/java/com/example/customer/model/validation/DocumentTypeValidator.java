package com.example.customer.model.validation;

import com.example.customer.model.enums.DocumentType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DocumentTypeValidator implements ConstraintValidator<DocumentTypeValidation, String> {
    private List<String> acceptedValues;

    @Override
    public void initialize(DocumentTypeValidation annotation) {
        this.acceptedValues = Stream.of(annotation.enumClass().getEnumConstants())
                .map(Enum::name)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        return acceptedValues.contains(value);
    }
}

