package com.example.customer.model.entity;

import com.example.customer.model.Address;
import com.example.customer.utils.FormatterUtil;
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

        this.street = FormatterUtil.formatField(address.getStreet());
        this.number = address.getNumber().trim();
        this.complement = FormatterUtil.formatField(address.getComplement());
        this.district = FormatterUtil.formatField(address.getDistrict());
        this.city = FormatterUtil.formatField(address.getCity());
        this.postalCode = address.getPostalCode().trim();
        this.country = FormatterUtil.formatField(address.getCountry());

    }
}
