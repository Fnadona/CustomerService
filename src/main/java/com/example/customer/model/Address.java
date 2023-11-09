package com.example.customer.model;

import com.example.customer.model.entity.AddressEntity;
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

    @NotBlank(message = "{blank.street.message}")
    @Pattern(regexp = "^([a-zA-Z]|[à-ü]|[À-Ü]|[0-9]|º|ª| )*$", message = "{invalid.street.format.message}")
    private String street;

    @NotBlank(message = "{blank.number.message}")
    @Pattern(regexp = "^[0-9]*$", message = "{invalid.number.format.message}")
    private String number;

    @Pattern(regexp = "^([a-zA-Z]|[à-ü]|[À-Ü]|[0-9]|º|ª| )*$", message = "{invalid.complement.format.message}")
    private String complement;

    @NotBlank(message = "{blank.district.message}")
    @Pattern(regexp = "^([a-zA-Z]|[à-ü]|[À-Ü]|[0-9]|º|ª| )*$", message = "{invalid.district.format.message}")
    private String district;

    @NotBlank(message = "{blank.city.message}")
    @Pattern(regexp = "^([a-zA-Z]|[à-ü]|[À-Ü]| )*$", message = "{invalid.city.format.message}")
    private String city;

    @NotBlank(message = "{blank.postal.code.message}")
    @Pattern(regexp = "^[0-9]*$", message = "{invalid.postal.code.format.message}")
    private String postalCode;

    @NotBlank(message = "{blank.country.message}")
    @Pattern(regexp = "^([a-zA-Z]|[à-ü]|[À-Ü]| )*$", message = "{invalid.country.format.message}")
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
