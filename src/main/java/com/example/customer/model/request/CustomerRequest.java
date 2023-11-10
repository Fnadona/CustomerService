package com.example.customer.model.request;

import com.example.customer.model.Address;
import com.example.customer.model.enums.DocumentType;
import com.example.customer.exceptions.structure.ErrorMessage;
import com.example.customer.model.validation.EnumValidation;
import com.example.customer.utils.RegexUtils;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CustomerRequest {

    @NotBlank(message = ErrorMessage.BLANK_NAME_MESSAGE)
    @Pattern(regexp = RegexUtils.LETTER_REGEX)
    private String name;

    @Valid
    @NotNull(message = ErrorMessage.NULL_ADDRESS_MESSAGE)
    private Address address;

    @NotNull(message = ErrorMessage.NULL_DOCUMENT_TYPE_MESSAGE)
    @EnumValidation(enumClass = DocumentType.class, message = ErrorMessage.INVALID_DOCUMENT_TYPE_MESSAGE)
    private String documentType;

    @NotBlank(message = ErrorMessage.BLANK_DOCUMENT_CODE_MESSAGE)
    private String documentCode;

    @NotBlank(message = ErrorMessage.BLANK_EMAIL_MESSAGE)
    @Email(message = ErrorMessage.INVALID_EMAIL_FORMAT_MESSAGE, flags = {Pattern.Flag.CASE_INSENSITIVE})
    private String email;

    @Pattern(regexp = RegexUtils.NUMBER_FIELD_REGEX, message = ErrorMessage.INVALID_PHONE_FORMAT_MESSAGE)
    @Length(min = 9, max=15, message = ErrorMessage.INVALID_PHONE_LENGTH_MESSAGE)
    private String phone;

}
