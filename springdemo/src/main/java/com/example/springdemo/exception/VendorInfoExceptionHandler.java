package com.example.springdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class VendorInfoExceptionHandler {

    @ExceptionHandler(value = {VendorInforNotFoundException.class})
    public ResponseEntity<Object> handleVendorInfoNotFoundException(VendorInforNotFoundException vendorInforNotFoundException) {
        VendorInfoException vendorInfoException = new VendorInfoException(vendorInforNotFoundException.getMessage(), vendorInforNotFoundException.getCause(), HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(vendorInfoException, HttpStatus.NOT_FOUND);
    }
}
