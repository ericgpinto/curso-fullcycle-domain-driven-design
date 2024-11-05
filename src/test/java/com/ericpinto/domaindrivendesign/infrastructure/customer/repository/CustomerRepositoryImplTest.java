package com.ericpinto.domaindrivendesign.infrastructure.customer.repository;

import com.ericpinto.domaindrivendesign.domain.customer.entity.Customer;
import com.ericpinto.domaindrivendesign.domain.customer.entity.valueobject.Address;
import com.ericpinto.domaindrivendesign.infrastructure.customer.model.CustomerModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@DataJpaTest
class CustomerRepositoryImplTest {

    private static final String ID = "123";
    private static final String NAME = "John";
    private static final String STREET = "Rua A";
    private static final Integer NUMBER = 649;
    private static final String CITY = "San Francisco";
    private static final String ZIPCODE = "964352";
    private static final Boolean ACTIVE = true;
    private static final Integer REWARD_POINTS = 0;

    CustomerModel customerModel = new CustomerModel(ID, NAME, STREET, NUMBER, CITY, ZIPCODE, ACTIVE, REWARD_POINTS );

    @Mock
    private CustomerJpaRepository customerJpaRepository;

    @InjectMocks
    private CustomerRepositoryImpl customerRepositoryImpl;

    @Test
    void shouldCreateCustomer() {
        Customer customer = new Customer(ID, NAME);
        customer.changeAddress(new Address(STREET, CITY, ZIPCODE, NUMBER));
        customer.activate();

        customerRepositoryImpl.save(customer);
        verify(customerJpaRepository, times(1)).save(customerModel);
    }

    @Test
    void shouldUpdateCustomer() {
        when(customerJpaRepository.findById(ID)).thenReturn(Optional.of(customerModel));

        Customer customer = new Customer(ID, NAME);
        customer.changeAddress(new Address(STREET, CITY, ZIPCODE, NUMBER));
        customer.activate();
        customer.changeName("Teste");

        customerRepositoryImpl.update(customer, customer.getId());

        Assertions.assertEquals(customer.getName(), "Teste");
    }

    @Test
    void shouldFindACustomer(){
        when(customerJpaRepository.findById(ID)).thenReturn(Optional.of(customerModel));

        Customer customer = customerRepositoryImpl.findById(ID);

        Assertions.assertNotNull(customer);
        Assertions.assertEquals("John", customer.getName());
    }

    @Test
    void shouldFindAllProducts(){
        CustomerModel customer2 = new CustomerModel("698", "Customer 2", "Rua C", 123 ,
                "POA", "9895", ACTIVE, REWARD_POINTS );

        when(customerJpaRepository.findAll()).thenReturn(List.of(customerModel, customer2));

        List<Customer> customers = customerRepositoryImpl.findAll();

        Assertions.assertEquals(2, customers.size());
    }
}