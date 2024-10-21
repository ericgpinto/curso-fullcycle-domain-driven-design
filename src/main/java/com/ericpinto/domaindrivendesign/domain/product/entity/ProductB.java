package com.ericpinto.domaindrivendesign.domain.product.entity;

public class ProductB implements IProduct{

    private String id;
    private String name;
    private Integer price;

    public ProductB(String id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.validate();
    }

    @Override
    public String getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void changeName(String name) {
        this.name = name;
        this.validate();
    }

    public Integer getPrice() {
        return price * 2;
    }

    public void changePrice(Integer price) {
        this.price = price;
        this.validate();
    }

    public void validate() {
        if(this.id.isEmpty()){
            throw new IllegalArgumentException("Id is required");
        }
        if(this.name.isEmpty()){
            throw new IllegalArgumentException("Name is required");
        }
        if(this.price <= 0){
            throw new IllegalArgumentException("Price must be greater than 0");
        }
    }
}
