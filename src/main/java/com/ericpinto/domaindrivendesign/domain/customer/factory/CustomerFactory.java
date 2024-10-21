package com.ericpinto.domaindrivendesign.domain.customer.factory;

import com.ericpinto.domaindrivendesign.domain.customer.entity.Customer;
import com.ericpinto.domaindrivendesign.domain.customer.entity.valueobject.Address;

import java.util.UUID;

public class CustomerFactory {

    public static Customer create(String name) {
        return new Customer(UUID.randomUUID().toString(), name);
    }

    public static Customer createWithAddress(String name, Address address) {
       Customer customer = new Customer(UUID.randomUUID().toString(), name);
       customer.changeAddress(address);
       return customer;
    }
}

