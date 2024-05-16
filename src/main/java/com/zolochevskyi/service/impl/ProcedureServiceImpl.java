package com.zolochevskyi.service.impl;

import com.zolochevskyi.service.ProcedureService;
import com.zolochevskyi.repository.TransportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcedureServiceImpl implements ProcedureService {
    @Autowired
    TransportRepo transportRepo;

    @Override
    public void insertIntoCustomer(String customerName, String customerAdress) {
        transportRepo.insertIntoCustomer(customerName, customerAdress);
    }

    @Override
    public void createSeveralTransports() {
        transportRepo.createSeveralTransports();
    }

    @Override
    public void avgDeliveryPrice(){
        transportRepo.avgDeliveryPrice();
    }

    @Override
    public void cursor(){
        transportRepo.cursor();
    }
}