package com.zolochevskyi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(itemRelation = "shop", collectionRelation = "shops")
public class ShopDto extends RepresentationModel<ShopDto> {
    private final Integer id;
    private final String country;
    private final String city;
    private final String adress;
}
