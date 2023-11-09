package com.example.customer.model.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target({FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = DocumentTypeValidator.class)
public @interface DocumentTypeValidation {
    Class<? extends Enum<?>> enumClass();
    String message() default "Document type is invalid. It must be one of types in {enumClass}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
