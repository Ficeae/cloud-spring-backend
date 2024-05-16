package com.zolochevskyi.service.impl;

import com.zolochevskyi.domain.Product;
import com.zolochevskyi.exception.ProductNotFoundExc;
import com.zolochevskyi.repository.ProductRepo;
import com.zolochevskyi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepo productRepo;

    @Transactional
    @Override
    public void update(Integer id, Product uProduct) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new ProductNotFoundExc(id));
        product.setManufacturer(uProduct.getManufacturer());
        product.setName(uProduct.getName());
        product.setCategory(uProduct.getCategory());
        product.setPrice(uProduct.getPrice());
        product.setArrived(uProduct.getArrived());
        product.setExpired(uProduct.getExpired());
        product.setIs_available(uProduct.getIs_available());
        productRepo.save(product);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new ProductNotFoundExc(id));
        productRepo.delete(product);
    }

    @Override
    public Product findById(Integer id) {
        return productRepo.findById(id).orElseThrow(() -> new ProductNotFoundExc(id));
    }

    @Transactional
    @Override
    public Product create(Product entity) {
        return productRepo.save(entity);
    }

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }
}