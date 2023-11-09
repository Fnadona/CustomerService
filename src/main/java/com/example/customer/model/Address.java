package com.example.customer.model;

import com.example.customer.model.entity.AddressEntity;
import com.example.customer.exceptions.ErrorMessage;
import com.example.customer.utils.RegexUtils;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Address {

    @NotBlank(message = ErrorMessage.BLANK_STREET_MESSAGE)
    @Pattern(regexp = RegexUtils.LETTER_AND_NUMBER_REGEX, message = ErrorMessage.INVALID_STREET_FORMAT_MESSAGE)
    private String street;

    @NotBlank(message = ErrorMessage.BLANK_NUMBER_MESSAGE)
    @Pattern(regexp = RegexUtils.NUMBER_FIELD_REGEX, message = ErrorMessage.INVALID_NUMBER_FORMAT_MESSAGE)
    private String number;

    @Pattern(regexp = RegexUtils.LETTER_AND_NUMBER_REGEX, message = ErrorMessage.INVALID_COMPLEMENT_FORMAT_MESSAGE)
    private String complement;

    @NotBlank(message = ErrorMessage.BLANK_DISTRICT_MESSAGE)
    @Pattern(regexp = RegexUtils.LETTER_AND_NUMBER_REGEX, message = ErrorMessage.INVALID_DISTRICT_FORMAT_MESSAGE)
    private String district;

    @NotBlank(message = ErrorMessage.BLANK_CITY_MESSAGE)
    @Pattern(regexp = RegexUtils.LETTER_REGEX, message = ErrorMessage.INVALID_CITY_FORMAT_MESSAGE)
    private String city;

    @NotBlank(message = ErrorMessage.BLANK_POSTAL_CODE_MESSAGE)
    @Pattern(regexp = RegexUtils.NUMBER_FIELD_REGEX, message = ErrorMessage.INVALID_POSTAL_CODE_FORMAT_MESSAGE)
    private String postalCode;

    @NotBlank(message = ErrorMessage.BLANK_COUNTRY_MESSAGE)
    @Pattern(regexp = RegexUtils.LETTER_REGEX, message = ErrorMessage.INVALID_COUNTRY_FORMAT_MESSAGE)
    private String country;

    public Address (AddressEntity addressEntity){

        this.street = addressEntity.getStreet();
        this.number = addressEntity.getNumber();
        this.complement = addressEntity.getComplement();
        this.district = addressEntity.getDistrict();
        this.city = addressEntity.getCity();
        this.postalCode = addressEntity.getPostalCode();
        this.country = addressEntity.getCountry();

    }
}
