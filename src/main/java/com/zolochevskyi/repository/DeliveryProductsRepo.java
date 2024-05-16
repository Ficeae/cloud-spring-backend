package com.zolochevskyi.repository;

import com.zolochevskyi.domain.DeliveryProducts;
import com.zolochevskyi.domain.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryProductsRepo extends JpaRepository<DeliveryProducts, Integer> {
}