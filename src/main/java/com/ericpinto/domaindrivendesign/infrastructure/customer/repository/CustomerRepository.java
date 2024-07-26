package com.ericpinto.domaindrivendesign.infrastructure.customer.repository;

import com.ericpinto.domaindrivendesign.infrastructure.customer.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, String> {
}
