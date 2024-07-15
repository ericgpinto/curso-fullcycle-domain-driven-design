package com.ericpinto.domaindrivendesign.domain.service;

import com.ericpinto.domaindrivendesign.domain.entity.Product;

import java.util.List;

public class ProductService {

    public static void increasePrice(List<Product> products, Integer percentage) {
        products.forEach(product -> {
            product.changePrice((product.getPrice() * percentage / 100) + product.getPrice()); ;
        });
    }
}
