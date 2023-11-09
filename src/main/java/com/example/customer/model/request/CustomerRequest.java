package com.example.customer.model.request;

import com.example.customer.model.Address;
import com.example.customer.model.enums.DocumentType;
import com.example.customer.model.validation.EnumValidation;
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

    @NotBlank(message = "{blank.name.message}")
    @Pattern(regexp = "^([a-zA-Z]|[à-ü]|[À-Ü]| )*$")
    private String name;

    @Valid
    @NotNull(message = "{null.address.message}")
    private Address address;

    @NotNull(message = "{null.document.type.message}")
    @EnumValidation(enumClass = DocumentType.class, message = "{invalid.document.type.message}")
    private String documentType;

    @NotBlank(message = "{blank.document.code.message}")
    private String documentCode;

    @NotBlank(message = "{blank.email.message}")
    @Email(message = "{invalid.email.message}", flags = {Pattern.Flag.CASE_INSENSITIVE})
    private String email;

    @Pattern(regexp = "^[0-9]+$", message = "{invalid.phone.format.message}")
    @Length(min = 9, max=15, message = "{invalid.phone.length.message}")
    private String phone;

}
