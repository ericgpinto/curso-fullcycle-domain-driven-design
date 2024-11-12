package com.ericpinto.domaindrivendesign.usecase.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutputCreateCustomerDTO {
    private String id;
    private String name;
    private String streetAddress;
    private String city;
    private String zipCode;
    private Integer number;
}
