package com.ericpinto.domaindrivendesign.domain.customer.repository;

import com.ericpinto.domaindrivendesign.domain.customer.entity.Customer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CustomerRepository {

    void save(Customer customer);
    void update(Customer customer);
    Customer findById(String id);
    List<Customer> findAll();
}
