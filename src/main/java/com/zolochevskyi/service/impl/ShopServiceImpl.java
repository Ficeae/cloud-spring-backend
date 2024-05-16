package com.zolochevskyi.service.impl;

import com.zolochevskyi.domain.Shop;
import com.zolochevskyi.exception.ShopNotFoundExc;
import com.zolochevskyi.repository.ShopRepo;
import com.zolochevskyi.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    ShopRepo shopRepo;

    @Transactional
    public void update(Integer id, Shop uShop) {
        Shop shop = shopRepo.findById(id)
                .orElseThrow(() -> new ShopNotFoundExc(id));
        shop.setCountry(uShop.getCountry());
        shop.setCity(uShop.getCity());
        shop.setAdress(uShop.getAdress());
        shopRepo.save(shop);
    }

    @Transactional
    public void delete(Integer id) {
        Shop shop = shopRepo.findById(id)
                .orElseThrow(() -> new ShopNotFoundExc(id));
        shopRepo.delete(shop);
    }

    public Shop findById(Integer id) {
        return shopRepo.findById(id).orElseThrow(() -> new ShopNotFoundExc(id));
    }

    @Transactional
    public Shop create(Shop entity) {
        return shopRepo.save(entity);
    }

    public List<Shop> findAll() {
        return shopRepo.findAll();
    }
}