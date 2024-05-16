package com.zolochevskyi.exception;

public class ProductNotFoundExc extends RuntimeException {
    public ProductNotFoundExc(Integer id){
        super("Could not find 'product' with id=" + id);
    }
}
