package com.zolochevskyi.repository;

import com.zolochevskyi.domain.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportRepo extends JpaRepository<Transport, Integer> {
    @Procedure("InsertIntoCustomer")
    void insertIntoCustomer(String customerName, String customerAdress);
    @Procedure("CreateSeveralTransports")
    void createSeveralTransports();
    @Procedure("AvgDeliveryPrice")
    void avgDeliveryPrice();
    @Procedure("DbCursor")
    void cursor();
}