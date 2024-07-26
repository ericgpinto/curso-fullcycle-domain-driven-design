package com.ericpinto.domaindrivendesign.domain.customer.entity.valueobject;

public class Address {

    private String street = "";
    private String city = "";
    private Integer number = 0;
    private String zip = "";

    public Address(String street, String city, String zip, Integer number) {
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.number = number;
        this.validate();
    }

    private void validate() {
        if (this.street.isEmpty()){
            throw new IllegalArgumentException("Street is required");
        }
        if (this.city.isEmpty()){
            throw new IllegalArgumentException("City is required");
        }
        if (this.zip.isEmpty()){
            throw new IllegalArgumentException("Zip is required");
        }
        if (this.number == 0){
            throw new IllegalArgumentException("Number is required");
        }
    }
}
