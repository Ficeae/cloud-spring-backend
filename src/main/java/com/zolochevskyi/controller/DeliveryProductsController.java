package com.zolochevskyi.controller;

import com.zolochevskyi.domain.DeliveryProducts;
import com.zolochevskyi.dto.DeliveryProductsDto;
import com.zolochevskyi.dto.assembler.DeliveryProductsDtoAssembler;
import com.zolochevskyi.service.DeliveryProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/deliveriesProducts")
public class DeliveryProductsController {
    @Autowired
    private DeliveryProductsService deliveryProductsService;
    @Autowired
    private DeliveryProductsDtoAssembler deliveryProductsDtoAssembler;

    @GetMapping(value = "/{deliveryProductsId}")
    public ResponseEntity<DeliveryProductsDto> getDeliveryProducts(@PathVariable Integer delivery_id) {
        DeliveryProducts deliveryProducts = deliveryProductsService.findById(delivery_id);
        DeliveryProductsDto deliveryProductsDto = deliveryProductsDtoAssembler.toModel(deliveryProducts);
        return new ResponseEntity<>(deliveryProductsDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<DeliveryProductsDto>> getAllDeliveryProducts() {
        List<DeliveryProducts> deliveryProducts = deliveryProductsService.findAll();
        CollectionModel<DeliveryProductsDto> deliveryProductsDtos = deliveryProductsDtoAssembler.toCollectionModel(deliveryProducts);
        return new ResponseEntity<>(deliveryProductsDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<DeliveryProductsDto> addDeliveryProducts(@RequestBody DeliveryProducts deliveryProducts) {
        DeliveryProducts newDeliveryProducts = deliveryProductsService.create(deliveryProducts);
        DeliveryProductsDto deliveryProductsDto = deliveryProductsDtoAssembler.toModel(newDeliveryProducts);
        return new ResponseEntity<>(deliveryProductsDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{deliveryProductsId}")
    public ResponseEntity<?> updateDeliveryProducts(@RequestBody DeliveryProducts deliveryProducts, @PathVariable Integer deliveryProductsId) {
        deliveryProductsService.update(deliveryProductsId, deliveryProducts);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{deliveryProductsId}")
    public ResponseEntity<?> deleteDeliveryProducts(@PathVariable Integer deliveryProductsId) {
        deliveryProductsService.delete(deliveryProductsId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
