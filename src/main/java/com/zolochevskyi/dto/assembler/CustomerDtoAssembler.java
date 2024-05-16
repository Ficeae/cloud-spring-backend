package com.zolochevskyi.dto.assembler;

import com.zolochevskyi.controller.CustomerController;
import com.zolochevskyi.domain.Customer;
import com.zolochevskyi.dto.CustomerDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CustomerDtoAssembler implements RepresentationModelAssembler<Customer, CustomerDto> {
    @Override
    public CustomerDto toModel(Customer entity) {
        CustomerDto customerDto = CustomerDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .adress(entity.getAdress())
                .build();
        Link selfLink = linkTo(methodOn(CustomerController.class).getCustomer(customerDto.getId())).withSelfRel();
        customerDto.add(selfLink);
        return customerDto;
    }

    @Override
    public CollectionModel<CustomerDto> toCollectionModel(Iterable<? extends Customer> entities) {
        CollectionModel<CustomerDto> customerDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(CustomerController.class).getAllCustomers()).withSelfRel();
        customerDtos.add(selfLink);
        return customerDtos;
    }
}
