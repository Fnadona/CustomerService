package com.example.customer.model;

import com.example.customer.model.entity.AddressEntity;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Address {

    @NotBlank(message = "The street is required")
    private String street;

    @NotBlank(message = "The number is required")
    private String number;

    private String complement;

    @NotBlank(message = "The district is required")
    private String district;

    @NotBlank(message = "The city is required")
    private String city;

    @NotBlank(message = "The postal code is required")
    private String postalCode;

    @NotBlank(message = "The country is required")
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
