package com.ericpinto.domaindrivendesign.infrastructure.controller;

import com.ericpinto.domaindrivendesign.usecase.customer.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CreateCustomerUseCase createCustomerUseCase;
    private final ListCustomerUseCase listCustomerUseCase;

    public CustomerController(CreateCustomerUseCase createCustomerUseCase,
                              ListCustomerUseCase listCustomerUseCase) {
        this.createCustomerUseCase = createCustomerUseCase;
        this.listCustomerUseCase = listCustomerUseCase;
    }
//
    @PostMapping
    public ResponseEntity<OutputCreateCustomerDTO> createCustomer(@RequestBody InputCreateCustomerDTO input) {
        try {
            return ResponseEntity.ok(createCustomerUseCase.execute(input));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<OutputListCustomerDTO>> findAll(){
        return ResponseEntity.ok(listCustomerUseCase.execute());
    }
}
