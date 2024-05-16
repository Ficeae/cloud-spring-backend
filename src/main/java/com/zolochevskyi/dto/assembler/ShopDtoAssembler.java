package com.zolochevskyi.dto.assembler;

import com.zolochevskyi.controller.ShopController;
import com.zolochevskyi.domain.Shop;
import com.zolochevskyi.dto.ShopDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ShopDtoAssembler implements RepresentationModelAssembler<Shop, ShopDto> {
    @Override
    public ShopDto toModel(Shop entity) {
        ShopDto shopDto = ShopDto.builder()
                .id(entity.getId())
                .country(entity.getCountry())
                .city(entity.getCity())
                .adress(entity.getAdress())
                .build();
        Link selfLink = linkTo(methodOn(ShopController.class).getShop(shopDto.getId())).withSelfRel();
        shopDto.add(selfLink);
        return shopDto;
    }

    @Override
    public CollectionModel<ShopDto> toCollectionModel(Iterable<? extends Shop> entities) {
        CollectionModel<ShopDto> shopDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(ShopController.class).getAllShops()).withSelfRel();
        shopDtos.add(selfLink);
        return shopDtos;
    }
}
