package com.zolochevskyi.exception;

public class DeliveryNotFoundExc extends RuntimeException {
    public DeliveryNotFoundExc(Integer id){
        super("Could not find 'delivery' with id=" + id);
    }
}
