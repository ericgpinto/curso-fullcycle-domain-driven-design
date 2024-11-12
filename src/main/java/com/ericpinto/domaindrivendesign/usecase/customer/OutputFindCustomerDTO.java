package com.ericpinto.domaindrivendesign.usecase.customer;

import com.ericpinto.domaindrivendesign.domain.customer.entity.valueobject.Address;

public record OutputFindCustomerDTO(String id, String name, Address address) {
}
