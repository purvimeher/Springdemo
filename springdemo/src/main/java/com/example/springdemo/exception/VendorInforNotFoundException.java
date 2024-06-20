package com.example.springdemo.exception;

public class VendorInforNotFoundException extends RuntimeException{


    public VendorInforNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public VendorInforNotFoundException(String message) {
        super(message);
    }
}
