package com.zolochevskyi.exception;

public class DeliveryProductsNotFoundExc extends RuntimeException {
    public DeliveryProductsNotFoundExc(Integer delivery_id){
        super("DeliveryProducts for 'delivery' with id=" + delivery_id + " not found");
    }
}
