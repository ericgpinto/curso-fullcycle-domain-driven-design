package com.ericpinto.domaindrivendesign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.ericpinto.domaindrivendesign.infrastructure.repository")
@EnableTransactionManagement
@EntityScan(basePackages="com.ericpinto.domaindrivendesign.infrastructure.db.model")
public class DomainDrivenDesignApplication {

    public static void main(String[] args) {
        SpringApplication.run(DomainDrivenDesignApplication.class, args);

    }

}
