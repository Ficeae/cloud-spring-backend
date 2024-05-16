package com.zolochevskyi.exception;

public class CustomerNotFoundExc extends RuntimeException {
    public CustomerNotFoundExc(Integer id){
        super("Could not find 'customer' with id=" + id);
    }
}
