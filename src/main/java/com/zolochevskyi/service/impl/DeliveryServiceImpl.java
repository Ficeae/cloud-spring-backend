package com.zolochevskyi.service.impl;

import com.zolochevskyi.domain.Delivery;
import com.zolochevskyi.exception.DeliveryNotFoundExc;
import com.zolochevskyi.repository.DeliveryRepo;
import com.zolochevskyi.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService {
    @Autowired
    DeliveryRepo deliveryRepo;

    @Transactional
    @Override
    public void update(Integer id, Delivery uDelivery) {
        Delivery delivery = deliveryRepo.findById(id)
                .orElseThrow(() -> new DeliveryNotFoundExc(id));
        delivery.setCustomer(uDelivery.getCustomer());
        delivery.setOrdered_time(uDelivery.getOrdered_time());
        delivery.setArrival(uDelivery.getArrival());
        delivery.setUrgency_price(uDelivery.getUrgency_price());
        deliveryRepo.save(delivery);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        Delivery delivery = deliveryRepo.findById(id)
                .orElseThrow(() -> new DeliveryNotFoundExc(id));
        deliveryRepo.delete(delivery);
    }

    @Override
    public Delivery findById(Integer id) {
        return deliveryRepo.findById(id).orElseThrow(() -> new DeliveryNotFoundExc(id));
    }

    @Transactional
    @Override
    public Delivery create(Delivery entity) {
        return deliveryRepo.save(entity);
    }

    @Override
    public List<Delivery> findAll() {
        return deliveryRepo.findAll();
    }
}