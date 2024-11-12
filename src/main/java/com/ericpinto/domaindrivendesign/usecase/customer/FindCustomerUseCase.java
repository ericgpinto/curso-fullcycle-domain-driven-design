package com.ericpinto.domaindrivendesign.usecase.customer;

import com.ericpinto.domaindrivendesign.domain.customer.entity.Customer;
import com.ericpinto.domaindrivendesign.domain.customer.repository.CustomerRepository;

public class FindCustomerUseCase {
    private final CustomerRepository customerRepository;

    public FindCustomerUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public OutputFindCustomerDto execute(InputFindCustomerDTO input) {
        Customer customer = customerRepository.findById(input.id());
        return new OutputFindCustomerDto(
                customer.getId(),
                customer.getName(),
                customer.getAddress()
        );
    }
}
