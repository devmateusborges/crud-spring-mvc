package com.fafram.products_crud.utils;

public class nsufficientStockException extends RuntimeException {
    public nsufficientStockException(String message) {
        super(message);
    }
}
