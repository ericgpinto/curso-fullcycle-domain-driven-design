package com.ericpinto.domaindrivendesign.domain.customer.factory;

import static org.junit.jupiter.api.Assertions.*;

import com.ericpinto.domaindrivendesign.domain.customer.entity.Customer;
import com.ericpinto.domaindrivendesign.domain.customer.entity.valueobject.Address;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomerFactoryTest {

    @Test
    void shouldCreateCustomer() {
        Customer customer = CustomerFactory.create("John");

        assertNotNull(customer.getId());
        assertEquals("John", customer.getName());
        assertNull(customer.getAddress());
    }

    @Test
    void shouldCreateCustomerWithAddress() {
        Address address = new Address("Street", "City", "Zip", 123);
        Customer customer = CustomerFactory.createWithAddress("John", address);

        assertNotNull(customer.getId());
        assertEquals("John", customer.getName());
        assertEquals(address, customer.getAddress());
    }

}
