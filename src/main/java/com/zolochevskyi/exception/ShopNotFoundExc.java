package com.zolochevskyi.exception;

public class ShopNotFoundExc extends RuntimeException {
    public ShopNotFoundExc(Integer id){
        super("Could not find 'shop' with id=" + id);
    }
}
