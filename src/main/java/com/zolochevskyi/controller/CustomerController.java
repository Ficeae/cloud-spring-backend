package com.zolochevskyi.controller;

import com.zolochevskyi.domain.Customer;
import com.zolochevskyi.dto.CustomerDto;
import com.zolochevskyi.dto.assembler.CustomerDtoAssembler;
import com.zolochevskyi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerDtoAssembler customerDtoAssembler;

    @GetMapping(value = "/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable Integer customerId) {
        Customer customer = customerService.findById(customerId);
        CustomerDto customerDto = customerDtoAssembler.toModel(customer);
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<CustomerDto>> getAllCustomers() {
        List<Customer> customers = customerService.findAll();
        CollectionModel<CustomerDto> customerDtos = customerDtoAssembler.toCollectionModel(customers);
        return new ResponseEntity<>(customerDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<CustomerDto> addCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerService.create(customer);
        CustomerDto customerDto = customerDtoAssembler.toModel(newCustomer);
        return new ResponseEntity<>(customerDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{customerId}")
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer, @PathVariable Integer customerId) {
        customerService.update(customerId, customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Integer customerId) {
        customerService.delete(customerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
