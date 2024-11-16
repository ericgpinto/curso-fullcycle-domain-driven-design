package com.ericpinto.domaindrivendesign.usecase.customer;

import com.ericpinto.domaindrivendesign.domain.customer.entity.Customer;
import com.ericpinto.domaindrivendesign.domain.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListCustomerUseCase {

    private final CustomerRepository customerRepository;

    public ListCustomerUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<OutputListCustomerDTO> execute(){
        List<Customer> customers = customerRepository.findAll();

        return customers.stream()
                .map((customer -> new OutputListCustomerDTO(
                        customer.getName(),
                        customer.getAddress().getStreet(),
                        customer.getAddress().getCity(),
                        customer.getAddress().getZip(),
                        customer.getAddress().getNumber()))).toList();
    }

}
