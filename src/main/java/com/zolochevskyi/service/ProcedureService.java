package com.zolochevskyi.service;

public interface ProcedureService {
    void insertIntoCustomer(String deliveryId, String transportId);
    void createSeveralTransports();
    void avgDeliveryPrice();
    void cursor();
}