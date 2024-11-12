package com.ericpinto.domaindrivendesign.usecase.customer;

import com.ericpinto.domaindrivendesign.domain.customer.entity.Customer;
import com.ericpinto.domaindrivendesign.domain.customer.entity.valueobject.Address;
import com.ericpinto.domaindrivendesign.domain.customer.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FindCustomerUseCaseTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private FindCustomerUseCase findCustomerUseCase;

    @Test
    void shouldFindCustomer(){
        Customer customer = new Customer("123", "John");
        Address address = new Address("Street", "City", "zip", 123);
        customer.changeAddress(address);

        Mockito.when(customerRepository.findById("123")).thenReturn(customer);

        InputFindCustomerDTO input = new InputFindCustomerDTO("123");

        OutputFindCustomerDto output = findCustomerUseCase.execute(input);

        assertNotNull(output);
        assertEquals("123", output.id());
        assertEquals("John", output.name());
    }

    @Test
    void shouldNotFindCustomer(){

        Mockito.when(customerRepository.findById("123")).thenThrow(RuntimeException.class);

        Customer customer = new Customer("123", "John");
        Address address = new Address("Street", "City", "zip", 123);
        customer.changeAddress(address);

        InputFindCustomerDTO input = new InputFindCustomerDTO("123");

        assertThrows(RuntimeException.class, () -> findCustomerUseCase.execute(input));
    }

//    @Test
//    void shouldCreateCustomer(){
//        CustomerCreateInputDTO createInputDTO = new CustomerCreateInputDTO();
//        createInputDTO.setName("John");
//        createInputDTO.setStreetAddress("Street");
//        createInputDTO.setCity("City");
//        createInputDTO.setZipCode("Zip");
//        createInputDTO.setNumber(123);
//
//        CustomerCreateOutputDTO createOutputDTO = customerService.create(createInputDTO);
//
//        assertNotNull(createOutputDTO);
//        assertEquals("John", createOutputDTO.getName());
//    }
//
//    @Test
//    void shouldThrowErrorWhenNameIsMissing(){
//        CustomerCreateInputDTO createInputDTO = new CustomerCreateInputDTO();
//        createInputDTO.setName("");
//        createInputDTO.setStreetAddress("Street");
//        createInputDTO.setCity("City");
//        createInputDTO.setZipCode("Zip");
//        createInputDTO.setNumber(123);
//
//        assertThrows(IllegalArgumentException.class, () -> {
//           customerService.create(createInputDTO);
//        }, "Name is required");
//    }
//
//    @Test
//    void shouldThrowErrorWhenStreetIsMissing(){
//        CustomerCreateInputDTO createInputDTO = new CustomerCreateInputDTO();
//        createInputDTO.setName("");
//        createInputDTO.setStreetAddress("");
//        createInputDTO.setCity("City");
//        createInputDTO.setZipCode("Zip");
//        createInputDTO.setNumber(123);
//
//        assertThrows(IllegalArgumentException.class, () -> {
//            customerService.create(createInputDTO);
//        }, "Street is required");
//    }



}