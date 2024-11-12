package com.ericpinto.domaindrivendesign.usecase.customer;

public record InputCreateCustomerDTO(
        String name,
        String streetAddress,
        String city,
        String zipCode,
        Integer number
){
}
