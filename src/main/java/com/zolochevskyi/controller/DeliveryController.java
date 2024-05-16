package com.zolochevskyi.controller;

import com.zolochevskyi.domain.Delivery;
import com.zolochevskyi.dto.DeliveryDto;
import com.zolochevskyi.dto.assembler.DeliveryDtoAssembler;
import com.zolochevskyi.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/deliveries")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;
    @Autowired
    private DeliveryDtoAssembler deliveryDtoAssembler;

    @GetMapping(value = "/{deliveryId}")
    public ResponseEntity<DeliveryDto> getDelivery(@PathVariable Integer deliveryId) {
        Delivery delivery = deliveryService.findById(deliveryId);
        DeliveryDto deliveryDto = deliveryDtoAssembler.toModel(delivery);
        return new ResponseEntity<>(deliveryDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<DeliveryDto>> getAllDeliveries() {
        List<Delivery> delivery = deliveryService.findAll();
        CollectionModel<DeliveryDto> deliveryDtos = deliveryDtoAssembler.toCollectionModel(delivery);
        return new ResponseEntity<>(deliveryDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<DeliveryDto> addDelivery(@RequestBody Delivery delivery) {
        Delivery newDelivery = deliveryService.create(delivery);
        DeliveryDto deliveryDto = deliveryDtoAssembler.toModel(newDelivery);
        return new ResponseEntity<>(deliveryDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{deliveryId}")
    public ResponseEntity<?> updateDelivery(@RequestBody Delivery delivery, @PathVariable Integer deliveryId) {
        deliveryService.update(deliveryId, delivery);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{deliveryId}")
    public ResponseEntity<?> deleteDelivery(@PathVariable Integer deliveryId) {
        deliveryService.delete(deliveryId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
