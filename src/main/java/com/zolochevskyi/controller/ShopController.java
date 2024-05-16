package com.zolochevskyi.controller;

import com.zolochevskyi.domain.Shop;
import com.zolochevskyi.dto.ShopDto;
import com.zolochevskyi.dto.assembler.ShopDtoAssembler;
import com.zolochevskyi.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/shops")
public class ShopController {
    @Autowired
    private ShopService shopService;
    @Autowired
    private ShopDtoAssembler shopDtoAssembler;

    @GetMapping(value = "/{shopId}")
    public ResponseEntity<ShopDto> getShop(@PathVariable Integer shopId) {
        Shop shop = shopService.findById(shopId);
        ShopDto shopDto = shopDtoAssembler.toModel(shop);
        return new ResponseEntity<>(shopDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<ShopDto>> getAllShops() {
        List<Shop> shops = shopService.findAll();
        CollectionModel<ShopDto> shopDtos = shopDtoAssembler.toCollectionModel(shops);
        return new ResponseEntity<>(shopDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<ShopDto> addShop(@RequestBody Shop shop) {
        Shop newShop = shopService.create(shop);
        ShopDto shopDto = shopDtoAssembler.toModel(newShop);
        return new ResponseEntity<>(shopDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{shopId}")
    public ResponseEntity<?> updateShop(@RequestBody Shop shop, @PathVariable Integer shopId) {
        shopService.update(shopId, shop);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{shopId}")
    public ResponseEntity<?> deleteShop(@PathVariable Integer shopId) {
        shopService.delete(shopId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
