package com.ericpinto.domaindrivendesign.infrastructure.db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity(name = "order_items")
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "product_id")
    private ProductModel product;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price;


}
