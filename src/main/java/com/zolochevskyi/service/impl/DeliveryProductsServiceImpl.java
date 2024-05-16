package com.zolochevskyi.service.impl;

import com.zolochevskyi.domain.DeliveryProducts;
import com.zolochevskyi.exception.DeliveryProductsNotFoundExc;
import com.zolochevskyi.repository.DeliveryProductsRepo;
import com.zolochevskyi.service.DeliveryProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DeliveryProductsServiceImpl implements DeliveryProductsService {
    @Autowired
    DeliveryProductsRepo deliveryProductsRepo;

    @Transactional
    @Override
    public void update(Integer id, DeliveryProducts uDeliveryProducts) {
        DeliveryProducts deliveryProducts = deliveryProductsRepo.findById(id)
                .orElseThrow(() -> new DeliveryProductsNotFoundExc(id));
        deliveryProducts.setProduct_id(uDeliveryProducts.getProduct_id());
        deliveryProducts.setQuantity(uDeliveryProducts.getQuantity());
        deliveryProducts.setPrice(uDeliveryProducts.getPrice());
        deliveryProducts.setWeight(uDeliveryProducts.getWeight());
        deliveryProductsRepo.save(deliveryProducts);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        DeliveryProducts deliveryProducts = deliveryProductsRepo.findById(id)
                .orElseThrow(() -> new DeliveryProductsNotFoundExc(id));
        deliveryProductsRepo.delete(deliveryProducts);
    }

    @Override
    public DeliveryProducts findById(Integer id) {
        return deliveryProductsRepo.findById(id).orElseThrow(() -> new DeliveryProductsNotFoundExc(id));
    }

    @Transactional
    @Override
    public DeliveryProducts create(DeliveryProducts entity) {
        return deliveryProductsRepo.save(entity);
    }

    @Override
    public List<DeliveryProducts> findAll() {
        return deliveryProductsRepo.findAll();
    }
}