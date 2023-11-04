package com.example.customer.model.entity;

import com.example.customer.model.Address;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ADDRESS_INFO")
@Data
@NoArgsConstructor
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COD_ID")
    private Long id;

    @OneToOne(mappedBy = "address")
    private CustomerEntity customerEntity;

    @Column(name = "DES_STREET")
    private String street;

    @Column(name = "DES_NUMBER")
    private String number;

    @Column(name = "DES_COMPLEMENT")
    private String complement;

    @Column(name = "DES_DISTRICT")
    private String district;

    @Column(name = "DES_CITY")
    private String city;

    @Column(name = "DES_POSTAL_CODE")
    private String postalCode;

    @Column(name = "DES_COUNTRY")
    private String country;

    public AddressEntity(Address address){

        this.street = address.getStreet();
        this.number = address.getNumber();
        this.complement = address.getComplement();
        this.district = address.getDistrict();
        this.city = address.getCity();
        this.postalCode = address.getPostalCode();
        this.country = address.getCountry();

    }
}
