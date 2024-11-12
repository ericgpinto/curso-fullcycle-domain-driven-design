package com.ericpinto.domaindrivendesign.usecase.customer;

import com.ericpinto.domaindrivendesign.domain.customer.entity.Customer;
import com.ericpinto.domaindrivendesign.domain.customer.entity.valueobject.Address;
import com.ericpinto.domaindrivendesign.domain.customer.factory.CustomerFactory;
import com.ericpinto.domaindrivendesign.domain.customer.repository.CustomerRepository;

public class UpdateCustomerUseCase {
    private final CustomerRepository customerRepository;

    public UpdateCustomerUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public OutputUpdateCustomerDTO execute(InputUpdateCustomerDTO input) {
        Customer customer = customerRepository.findById(input.id());
        customer.changeName(input.name());
        customer.changeAddress(new Address(input.street(), input.city(), input.zip(), input.number()));

        customerRepository.update(customer);

        return new OutputUpdateCustomerDTO(
                customer.getId(),
                customer.getName(),
                customer.getAddress().getStreet(),
                customer.getAddress().getCity(),
                customer.getAddress().getZip(),
                customer.getAddress().getNumber()
        );
    }
}
