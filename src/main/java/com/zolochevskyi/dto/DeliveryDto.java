package com.zolochevskyi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(itemRelation = "delivery", collectionRelation = "deliveries")
public class DeliveryDto extends RepresentationModel<DeliveryDto> {
    private final Integer id;
    private final Integer customer_id;
    private final Timestamp ordered_time;
    private final Time arrival;
    private final Double urgency_price;
}
