package com.zolochevskyi.dto.assembler;

import com.zolochevskyi.domain.Delivery;
import com.zolochevskyi.dto.DeliveryDto;
import com.zolochevskyi.controller.DeliveryController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class DeliveryDtoAssembler implements RepresentationModelAssembler<Delivery, DeliveryDto> {
    @Override
    public DeliveryDto toModel(Delivery entity) {
        DeliveryDto deliveryDto = DeliveryDto.builder()
                .id(entity.getId())
                .ordered_time(entity.getOrdered_time())
                .arrival(entity.getArrival())
                .urgency_price(entity.getUrgency_price())
                .build();
        Link selfLink = linkTo(methodOn(DeliveryController.class).getDelivery(deliveryDto.getId())).withSelfRel();
        deliveryDto.add(selfLink);
        return deliveryDto;
    }

    @Override
    public CollectionModel<DeliveryDto> toCollectionModel(Iterable<? extends Delivery> entities) {
        CollectionModel<DeliveryDto> deliveryDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(DeliveryController.class).getAllDeliveries()).withSelfRel();
        deliveryDtos.add(selfLink);
        return deliveryDtos;
    }
}
