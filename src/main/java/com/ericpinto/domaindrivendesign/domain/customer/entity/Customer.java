package com.ericpinto.domaindrivendesign.domain.customer.entity;

import com.ericpinto.domaindrivendesign.domain.customer.entity.valueobject.Address;
import com.ericpinto.domaindrivendesign.domain.shared.entity.Entity;
import com.ericpinto.domaindrivendesign.domain.shared.notification.NotificationError;
import com.ericpinto.domaindrivendesign.domain.shared.notification.NotificationException;

import java.util.Objects;

public class Customer extends Entity {

    private String name;
    private Address address;
    private Boolean active = false;
    private Integer rewardPoints = 0;

    public Customer(String id, String name){
        super();
        this.id = id;
        this.name = name;
        this.validate();

        if (this.notification.hasErrors()){
            throw new NotificationException(this.notification.getErrors());
        }
    }

    private void validate() {
        if (this.id.isEmpty()){
            this.notification.addError(new NotificationError("Id is required", "customer"));
        }
        if(this.name.isEmpty()){
            this.notification.addError(new NotificationError("Name is required", "customer"));
        }
    }

    public void changeName(String name) {
        this.name = name;
        this.validate();
    }

    public void changeAddress(Address address) {
        this.address = address;
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

    public Address getAddress() {
        return address;
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
