package com.ericpinto.domaindrivendesign.usecase.customer;

import com.ericpinto.domaindrivendesign.domain.customer.entity.Customer;
import com.ericpinto.domaindrivendesign.domain.customer.entity.valueobject.Address;
import com.ericpinto.domaindrivendesign.domain.customer.factory.CustomerFactory;
import com.ericpinto.domaindrivendesign.domain.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateCustomerUseCase {
    private final CustomerRepository customerRepository;

    public CreateCustomerUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public OutputCreateCustomerDTO execute(InputCreateCustomerDTO input) {
        Customer customer = CustomerFactory.createWithAddress(input.name(),
                new Address(input.streetAddress(), input.city(), input.zipCode(), input.number()));

        customerRepository.save(customer);

        return new OutputCreateCustomerDTO(
                customer.getId(),
                customer.getName(),
                customer.getAddress().getStreet(),
                customer.getAddress().getCity(),
                customer.getAddress().getZip(),
                customer.getAddress().getNumber()
        );
    }
}
