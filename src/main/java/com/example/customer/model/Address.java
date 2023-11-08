package com.example.customer.model;

import com.example.customer.model.entity.AddressEntity;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Address {

    private String street;
    private String number;
    private String complement;
    private String district;
    private String city;
    private String postalCode;
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
