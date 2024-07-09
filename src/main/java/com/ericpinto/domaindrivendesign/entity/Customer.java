package com.ericpinto.domaindrivendesign.entity;

public class Customer {

    private String id;
    private String name;
    private String address;
    private Boolean active;

    public Customer(String id, String name){
        this.id = id;
        this.name = name;
        this.validate();
    }

    private void validate() {
        if(this.name.isEmpty()){
            throw new IllegalArgumentException("Customer is required");
        }
        if (this.id.isEmpty()){
            throw new IllegalArgumentException("Customer id is required");
        }
    }

    public void changeName(String name) {
        this.name = name;
    }
}
