package com.ericpinto.domaindrivendesign.domain.product.factory;

import com.ericpinto.domaindrivendesign.domain.product.entity.IProduct;
import com.ericpinto.domaindrivendesign.domain.product.entity.Product;
import com.ericpinto.domaindrivendesign.domain.product.entity.ProductB;

import java.util.UUID;

public class ProductFactory {

    public static IProduct create(String type, String name, Integer price){
        return switch (type) {
            case "a" -> new Product(UUID.randomUUID().toString(), name, price);
            case "b" -> new ProductB(UUID.randomUUID().toString(), name, price);
            default -> throw new IllegalArgumentException("Unknown product type: " + type);
        };
    }
}
