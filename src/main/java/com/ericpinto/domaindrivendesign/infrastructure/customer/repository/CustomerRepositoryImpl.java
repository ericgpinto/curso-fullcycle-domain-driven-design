package com.ericpinto.domaindrivendesign.infrastructure.customer.repository;

import com.ericpinto.domaindrivendesign.domain.customer.entity.Customer;
import com.ericpinto.domaindrivendesign.domain.customer.entity.valueobject.Address;
import com.ericpinto.domaindrivendesign.domain.customer.repository.CustomerRepository;
import com.ericpinto.domaindrivendesign.infrastructure.customer.model.CustomerModel;

import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerJpaRepository customerJpaRepository;

    public CustomerRepositoryImpl(CustomerJpaRepository customerJpaRepository) {
        this.customerJpaRepository = customerJpaRepository;
    }

    @Override
    public void save(Customer customer) {
        CustomerModel customerModel = toModel(customer);
        customerJpaRepository.save(customerModel);
    }

    @Override
    public void update(Customer customer) {
        Customer customerFounded = findById(customer.getId());
        customerJpaRepository.save(toModel(customerFounded));
    }

    @Override
    public Customer findById(String id) {
        CustomerModel customerModel = customerJpaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find customer with id: " + id));
        Customer customer = toDomain(customerModel);
        customer.changeAddress(new Address(customerModel.getStreet(),
                customerModel.getCity(),
                customerModel.getZipCode(),
                customerModel.getNumber()));

        return customer;
    }


    @Override
    public List<Customer> findAll() {
        return customerJpaRepository.findAll()
                .stream()
                .map(this::toDomain)
                .toList();
    }

    private Customer toDomain(CustomerModel customerModel) {
        return new Customer(customerModel.getId(), customerModel.getName()
        );
    }

    private CustomerModel toModel(Customer customer) {
        return new CustomerModel(
                customer.getId(),
                customer.getName(),
                customer.getAddress().getStreet(),
                customer.getAddress().getNumber(),
                customer.getAddress().getCity(),
                customer.getAddress().getZip(),
                customer.isActive(),
                customer.getRewardPoints()
        );
    }
}
