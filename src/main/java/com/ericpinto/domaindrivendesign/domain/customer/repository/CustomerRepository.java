package com.ericpinto.domaindrivendesign.domain.customer.repository;

import com.ericpinto.domaindrivendesign.domain.customer.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

    void save(Customer customer);
    void update(Customer customer);
    Customer findById(String id);
    List<Customer> findAll();
}
