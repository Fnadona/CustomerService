package com.example.customer.service;

import com.example.customer.CustomerApplication;
import com.example.customer.exceptions.ParseErrorException;
import com.example.customer.exceptions.PersistenceErrorException;
import com.example.customer.model.entity.CustomerEntity;
import com.example.customer.model.enums.AccountStatus;
import com.example.customer.model.request.CustomerRequest;
import com.example.customer.model.response.CustomerResponse;
import com.example.customer.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.OptimisticLockingFailureException;

import static org.mockito.Mockito.*;

@SpringBootTest(classes = {CustomerApplication.class})
public class ServiceTest {

    @Autowired
    private CustomerService customerService;

    private static final Logger log = LoggerFactory.getLogger(ServiceTest.class.getSimpleName());

    @Test
    @DisplayName("Testing registerCustomer method with success cases")
    public void registerCustomerSuccessTest(){
        CustomerRequestProvider.getProviders()
                .forEach((message,request) -> {
                    log.info(message);
                    makeAsserts(request);
                });
    }

    @Test
    @DisplayName("Testing registerCustomer method with parse exception")
    public void registerCustomerParseExceptionTest(){
        buildRegisterCustomerErrors(NullPointerException.class, ParseErrorException.class);
    }

    @Test
    @DisplayName("Testing registerCustomer method with persistence exception")
    public void registerCustomerPersistenceExceptionTest(){
        buildRegisterCustomerErrors(IllegalArgumentException.class, PersistenceErrorException.class);
        buildRegisterCustomerErrors(OptimisticLockingFailureException.class, PersistenceErrorException.class);
    }

    private void buildRegisterCustomerErrors (Class<? extends RuntimeException> errorInput,Class<? extends RuntimeException> errorOutput){
        CustomerRepository customerRepositoryMock = mock(CustomerRepository.class);
        CustomerResponse customerResponseMock = mock(CustomerResponse.class);
        CustomerRequest customerRequestMock = CustomerRequestProvider.customerRequestWithAllFields;
        CustomerEntity customerEntityMock = new CustomerEntity(customerRequestMock);
        CustomerService customerServiceMock = spy(new CustomerServiceImpl(customerRepositoryMock, customerResponseMock));

        when(customerRepositoryMock.save(customerEntityMock)).thenThrow(errorInput);

        Assertions.assertThrows(errorOutput, () -> customerServiceMock.registerCustomer(customerRequestMock));
    }
    private void makeAsserts(CustomerRequest customerRequest){

        CustomerResponse customerResponse = customerService.registerCustomer(customerRequest);

        Assertions.assertNotNull(customerResponse.getCustomerId());

        Assertions.assertEquals(customerRequest.getName().toUpperCase(), customerResponse.getName());
        Assertions.assertEquals(customerRequest.getDocumentType().toUpperCase(), customerResponse.getDocumentType());
        Assertions.assertEquals(customerRequest.getDocumentCode().toUpperCase(), customerResponse.getDocumentCode());
        Assertions.assertEquals(customerRequest.getEmail().toUpperCase(), customerResponse.getEmail());
        Assertions.assertEquals(customerRequest.getPhone(), customerResponse.getPhone());
        Assertions.assertEquals(AccountStatus.INACTIVE.name(), customerResponse.getAccountStatus());

        Assertions.assertEquals(customerRequest.getAddress().getStreet().toUpperCase(), customerResponse.getAddress().getStreet());
        Assertions.assertEquals(customerRequest.getAddress().getNumber(), customerResponse.getAddress().getNumber());
        Assertions.assertEquals(customerRequest.getAddress().getComplement().toUpperCase(), customerResponse.getAddress().getComplement());
        Assertions.assertEquals(customerRequest.getAddress().getDistrict().toUpperCase(), customerResponse.getAddress().getDistrict());
        Assertions.assertEquals(customerRequest.getAddress().getPostalCode(), customerResponse.getAddress().getPostalCode());
        Assertions.assertEquals(customerRequest.getAddress().getCountry().toUpperCase(), customerResponse.getAddress().getCountry());
        Assertions.assertEquals(customerRequest.getAddress().getCity().toUpperCase(), customerResponse.getAddress().getCity());
    }

}
