package com.ericpinto.domaindrivendesign.infrastructure.customer.repository;

import com.ericpinto.domaindrivendesign.infrastructure.customer.model.CustomerModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@DataJpaTest
class CustomerRepositoryTest {

    private CustomerRepository customerRepository;

    private static final String ID = "123";
    private static final String NAME = "John";
    private static final String STREET = "Rua A";
    private static final Integer NUMBER = 649;
    private static final String CITY = "San Francisco";
    private static final String ZIPCODE = "964352";
    private static final Boolean ACTIVE = true;
    private static final Integer REWARD_POINTS = 0;

    CustomerModel customerModel = new CustomerModel(ID, NAME, STREET, NUMBER, CITY, ZIPCODE, ACTIVE, REWARD_POINTS );

    @BeforeEach
    void setUp() {
        customerRepository = mock(CustomerRepository.class);
    }

    @Test
    void shouldCreateCustomer() {
        customerRepository.save(customerModel);

        verify(customerRepository, times(1)).save(customerModel);
    }

    @Test
    void shouldUpdateCustomer() {
        when(customerRepository.findById(ID)).thenReturn(Optional.of(customerModel));
        customerModel.setName("Customer 2");

        customerRepository.save(customerModel);

        verify(customerRepository, times(1)).save(customerModel);
        Assertions.assertEquals(customerModel.getName(), "Customer 2");
    }

    @Test
    void shouldFindACustomer(){
        when(customerRepository.findById(ID)).thenReturn(Optional.of(customerModel));

        CustomerModel customerFounded = customerRepository.findById(ID).get();

        Assertions.assertEquals(customerModel.getId(), customerFounded.getId());
        Assertions.assertEquals(customerModel.getName(), customerFounded.getName());
        Assertions.assertEquals(customerModel.getStreet(), customerFounded.getStreet());
        Assertions.assertEquals(customerModel.getNumber(), customerFounded.getNumber());
        Assertions.assertEquals(customerModel.getCity(), customerFounded.getCity());
        Assertions.assertEquals(customerModel.getZipCode(), customerFounded.getZipCode());
        Assertions.assertEquals(customerModel.getActive(), customerFounded.getActive());
        Assertions.assertEquals(customerModel.getRewardPoints(), customerFounded.getRewardPoints());
    }

    @Test
    void shouldThrowExceptionIfCustomerNotFound() {
        when(customerRepository.findById(ID)).thenThrow(RuntimeException.class);
        Assertions.assertThrows(RuntimeException.class, () -> customerRepository.findById(ID));
    }

    @Test
    void shouldFindAllProducts(){
        CustomerModel customer2 = new CustomerModel("698", "Customer 2", "Rua C", 123 ,
                "POA", "9895", ACTIVE, REWARD_POINTS );

        when(customerRepository.findAll()).thenReturn(List.of(customerModel, customer2));

        List<CustomerModel> customers = customerRepository.findAll();

        Assertions.assertEquals(2, customers.size());
        Assertions.assertEquals(customerModel, customers.get(0));
        Assertions.assertEquals(customer2, customers.get(1));

    }
}