package com.ericpinto.domaindrivendesign.infrastructure.repository;

import com.ericpinto.domaindrivendesign.infrastructure.db.model.CustomerModel;
import com.ericpinto.domaindrivendesign.infrastructure.db.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, String> {
}
