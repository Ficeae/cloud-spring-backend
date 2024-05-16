package com.zolochevskyi.dto.assembler;

import com.zolochevskyi.controller.ProductController;
import com.zolochevskyi.domain.Product;
import com.zolochevskyi.dto.ProductDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProductDtoAssembler implements RepresentationModelAssembler<Product, ProductDto> {
    @Override
    public ProductDto toModel(Product entity) {
        ProductDto productDto = ProductDto.builder()
                .id(entity.getId())
                .manufacturer(entity.getManufacturer())
                .name(entity.getName())
                .category(entity.getCategory())
                .price(entity.getPrice())
                .arrived(entity.getArrived())
                .expired(entity.getExpired())
                .is_available(entity.getIs_available())
                .build();
        Link selfLink = linkTo(methodOn(ProductController.class).getProduct(productDto.getId())).withSelfRel();
        productDto.add(selfLink);
        return productDto;
    }

    @Override
    public CollectionModel<ProductDto> toCollectionModel(Iterable<? extends Product> entities) {
        CollectionModel<ProductDto> productDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(ProductController.class).getAllProducts()).withSelfRel();
        productDtos.add(selfLink);
        return productDtos;
    }
}
