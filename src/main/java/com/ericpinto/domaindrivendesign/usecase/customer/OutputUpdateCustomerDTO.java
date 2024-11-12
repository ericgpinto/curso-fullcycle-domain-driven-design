package com.ericpinto.domaindrivendesign.usecase.customer;

import com.ericpinto.domaindrivendesign.domain.customer.entity.valueobject.Address;

public record OutputUpdateCustomerDTO(
        String id,
        String name,
        String street,
        String city,
        String zip,
        Integer number
) {
}
