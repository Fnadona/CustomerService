package com.example.customer.response;

import com.example.customer.model.entity.AddressEntity;
import com.example.customer.model.entity.CustomerEntity;
import com.example.customer.model.enums.AccountStatus;
import com.example.customer.model.enums.DocumentType;
import com.example.customer.model.response.CustomerResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerResponseTest {

    @Autowired
    private CustomerResponse customerResponse;

    @Test
    @DisplayName("Testing fromEntity method")
    void fromEntityTest(){
        CustomerEntity customerEntity = createCustomerEntity();
        CustomerResponse response = customerResponse.fromEntity(customerEntity);

        Assertions.assertNotNull(response.getCustomerId());

        Assertions.assertEquals(customerEntity.getName(), response.getName());
        Assertions.assertEquals(DocumentType.valueOf(customerEntity.getDocumentType()), response.getDocumentType());
        Assertions.assertEquals(customerEntity.getDocument(), response.getDocument());
        Assertions.assertEquals(customerEntity.getEmail(), response.getEmail());
        Assertions.assertEquals(customerEntity.getPhone(), response.getPhone());
        Assertions.assertEquals(AccountStatus.valueOf(customerEntity.getAccountStatus()), response.getAccountStatus());

        Assertions.assertEquals(customerEntity.getAddress().getStreet(), response.getAddress().getStreet());
        Assertions.assertEquals(customerEntity.getAddress().getNumber(), response.getAddress().getNumber());
        Assertions.assertEquals(customerEntity.getAddress().getComplement(), response.getAddress().getComplement());
        Assertions.assertEquals(customerEntity.getAddress().getDistrict(), response.getAddress().getDistrict());
        Assertions.assertEquals(customerEntity.getAddress().getPostalCode(), response.getAddress().getPostalCode());
        Assertions.assertEquals(customerEntity.getAddress().getCountry(), response.getAddress().getCountry());
        Assertions.assertEquals(customerEntity.getAddress().getCity(), response.getAddress().getCity());
    }

    private CustomerEntity createCustomerEntity(){

        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setId(123L);
        customerEntity.setName("Nome teste");
        customerEntity.setAddress(createAddressEntity());
        customerEntity.setDocumentType(DocumentType.DRIVE_LICENSE.name());
        customerEntity.setDocument("documento teste");
        customerEntity.setEmail("emailteste@teste.com");
        customerEntity.setPhone("321654987");
        customerEntity.setAccountStatus(AccountStatus.INACTIVE.name());

        return customerEntity;
    }

    private AddressEntity createAddressEntity(){

        AddressEntity addressEntity = new AddressEntity();

        addressEntity.setId(123L);
        addressEntity.setStreet("Rua teste");
        addressEntity.setNumber("123456");
        addressEntity.setComplement("Complemento teste");
        addressEntity.setDistrict("Bairro teste");
        addressEntity.setPostalCode("12345678");
        addressEntity.setCountry("Pais teste");
        addressEntity.setCity("Cidade teste");

        return addressEntity;
    }
}
