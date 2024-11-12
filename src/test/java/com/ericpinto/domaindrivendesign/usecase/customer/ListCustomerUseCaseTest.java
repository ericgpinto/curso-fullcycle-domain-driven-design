package com.ericpinto.domaindrivendesign.usecase.customer;

import com.ericpinto.domaindrivendesign.domain.customer.entity.Customer;
import com.ericpinto.domaindrivendesign.domain.customer.entity.valueobject.Address;
import com.ericpinto.domaindrivendesign.domain.customer.factory.CustomerFactory;
import com.ericpinto.domaindrivendesign.domain.customer.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ListCustomerUseCaseTest {

    Customer customer1;
    Customer customer2;

    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    ListCustomerUseCase listCustomerUseCase;

    @BeforeEach
    public void setUp() {
        customer1 = CustomerFactory.createWithAddress("John", new Address("Street 1", "City 1", "Zip 1", 1));
        customer2 = CustomerFactory.createWithAddress("Sarah", new Address("Street 2", "City 2", "Zip 2", 2));
    }

    @Test
    void shouldListCustomers() {
        Mockito.when(customerRepository.findAll()).thenReturn(List.of(customer1, customer2));
        List<OutputListCustomerDTO> output = listCustomerUseCase.execute();

        Mockito.verify(customerRepository, Mockito.times(1)).findAll();

        assertEquals(output.size(), 2);
        assertEquals(output.get(0).name(), customer1.getName());
        assertEquals(output.get(1).name(), customer2.getName());
    }
}
