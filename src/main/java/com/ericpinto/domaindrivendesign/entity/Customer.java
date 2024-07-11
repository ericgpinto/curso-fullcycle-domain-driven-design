package com.ericpinto.domaindrivendesign.entity;

import java.util.Objects;

public class Customer {

    private final String id;
    private String name;
    private Address address;
    private Boolean active = false;
    private Integer rewardPoints = 0;

    public Customer(String id, String name){
        this.id = id;
        this.name = name;
        this.validate();
    }

    private void validate() {
        if(this.name.isEmpty()){
            throw new IllegalArgumentException("Customer name is required");
        }
        if (this.id.isEmpty()){
            throw new IllegalArgumentException("Customer id is required");
        }
    }

    public void changeName(String name) {
        this.name = name;
        this.validate();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getRewardPoints() {
        return rewardPoints;
    }

    public Boolean isActive(){
        return this.active;
    }

    public void activate(){
        if (Objects.isNull(this.address)){
            throw new IllegalArgumentException("Address is mandatory to activate a customer");
        }
        this.active = true;
    }

    public void deactivate(){
        this.active = false;
    }


    public Integer addRewardPoints(Integer points){
        return this.rewardPoints += points;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
