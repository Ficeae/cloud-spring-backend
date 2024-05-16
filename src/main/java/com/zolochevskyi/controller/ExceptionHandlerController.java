package com.zolochevskyi.controller;

import com.zolochevskyi.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {
    @ResponseBody
    @ExceptionHandler(CustomerNotFoundExc.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String customerNotFoundHandler(CustomerNotFoundExc ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(DeliveryNotFoundExc.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String deliveryNotFoundHandler(DeliveryNotFoundExc ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(DeliveryProductsNotFoundExc.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String deliveryProductsNotFoundHandler(DeliveryProductsNotFoundExc ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(ProductNotFoundExc.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String productNotFoundHandler(ProductNotFoundExc ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(ShopNotFoundExc.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String shopNotFoundHandler(ShopNotFoundExc ex) {
        return ex.getMessage();
    }
}
