package com.zolochevskyi.controller;

import com.zolochevskyi.domain.Product;
import com.zolochevskyi.dto.ProductDto;
import com.zolochevskyi.dto.assembler.ProductDtoAssembler;
import com.zolochevskyi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductDtoAssembler productDtoAssembler;

    @GetMapping(value = "/{productId}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Integer shopId) {
        Product shop = productService.findById(shopId);
        ProductDto shopDto = productDtoAssembler.toModel(shop);
        return new ResponseEntity<>(shopDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<ProductDto>> getAllProducts() {
        List<Product> products = productService.findAll();
        CollectionModel<ProductDto> productDtos = productDtoAssembler.toCollectionModel(products);
        return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<ProductDto> addProduct(@RequestBody Product product) {
        Product newProduct = productService.create(product);
        ProductDto productDto = productDtoAssembler.toModel(newProduct);
        return new ResponseEntity<>(productDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{productId}")
    public ResponseEntity<?> updateProduct(@RequestBody Product product, @PathVariable Integer productId) {
        productService.update(productId, product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId) {
        productService.delete(productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
