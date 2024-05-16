package com.zolochevskyi.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.zolochevskyi.service.ProcedureService;


@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping(value = "/api/procedures")
public class ProcedureController {
    @Autowired
    private ProcedureService procedureService;

    @PostMapping("/insertIntoCustomer/{customerName}/{customerAdress}")
    public ResponseEntity<?> insertIntoCustomer(@PathVariable String customerName, @PathVariable String customerAdress){
        procedureService.insertIntoCustomer(customerName, customerAdress);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/createSeveralTransports")
    public ResponseEntity<?> createSeveralTransports(){
        procedureService.createSeveralTransports();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/avgDeliveryPrice")
    public ResponseEntity<?> avgDeliveryPrice(){
        procedureService.avgDeliveryPrice();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/cursor")
    public ResponseEntity<?> cursor(){
        procedureService.cursor();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
