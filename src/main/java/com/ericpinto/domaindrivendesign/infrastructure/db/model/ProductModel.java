package com.ericpinto.domaindrivendesign.infrastructure.db.model;

import com.ericpinto.domaindrivendesign.domain.entity.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price;

    public ProductModel(Product product) {
        this.name = product.getName();
        this.price = product.getPrice();
    }
}
