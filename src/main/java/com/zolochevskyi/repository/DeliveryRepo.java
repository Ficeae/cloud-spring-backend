package com.zolochevskyi.repository;

import com.zolochevskyi.domain.Delivery;
import com.zolochevskyi.domain.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepo extends JpaRepository<Delivery, Integer> {
}