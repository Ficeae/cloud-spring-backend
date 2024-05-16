package com.zolochevskyi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.sql.Time;
import java.sql.Timestamp;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(itemRelation = "deliveryProducts", collectionRelation = "deliveriesProducts")
public class DeliveryProductsDto extends RepresentationModel<DeliveryProductsDto> {
    private final Integer id;
    private final Integer product_id;
    private final Integer delivery_id;
    private final Integer quantity;
    private final Double weight;
    private final Double price;
}
