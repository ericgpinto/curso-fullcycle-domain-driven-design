package com.ericpinto.domaindrivendesign.usecase.customer;

public record OutputListCustomerDTO(
        String name,
        String street,
        String city,
        String zip,
        Integer number
) {
}
