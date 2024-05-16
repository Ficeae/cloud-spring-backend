package com.zolochevskyi.dto.assembler;

import com.zolochevskyi.controller.DeliveryProductsController;
import com.zolochevskyi.domain.DeliveryProducts;
import com.zolochevskyi.dto.DeliveryProductsDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class DeliveryProductsDtoAssembler implements RepresentationModelAssembler<DeliveryProducts, DeliveryProductsDto> {
    @Override
    public DeliveryProductsDto toModel(DeliveryProducts entity) {
        DeliveryProductsDto deliveryProductsDto = DeliveryProductsDto.builder()
                .product_id(entity.getProduct_id().getId())
                .delivery_id(entity.getDelivery_id().getId())
                .quantity(entity.getQuantity())
                .weight(entity.getWeight())
                .price(entity.getPrice())
                .build();
        Link selfLink = linkTo(methodOn(DeliveryProductsController.class).getDeliveryProducts(deliveryProductsDto.getId())).withSelfRel();
        deliveryProductsDto.add(selfLink);
        return deliveryProductsDto;
    }

    @Override
    public CollectionModel<DeliveryProductsDto> toCollectionModel(Iterable<? extends DeliveryProducts> entities) {
        CollectionModel<DeliveryProductsDto> deliveryProductsDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(DeliveryProductsController.class).getAllDeliveryProducts()).withSelfRel();
        deliveryProductsDtos.add(selfLink);
        return deliveryProductsDtos;
    }
}
