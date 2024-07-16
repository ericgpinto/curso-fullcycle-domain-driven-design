package com.ericpinto.domaindrivendesign.infrastructure.repository;

import com.ericpinto.domaindrivendesign.infrastructure.db.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, String> {
}
