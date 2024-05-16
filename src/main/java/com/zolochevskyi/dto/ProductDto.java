package com.zolochevskyi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.sql.Date;
import java.sql.Timestamp;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(itemRelation = "product", collectionRelation = "product")
public class ProductDto extends RepresentationModel<ProductDto> {
    private final Integer id;
    private final Integer shop_id;
    private final String manufacturer;
    private final String name;
    private final String category;
    private final Double price;
    private final Timestamp arrived;
    private final Date expired;
    private final Boolean is_available;
}
