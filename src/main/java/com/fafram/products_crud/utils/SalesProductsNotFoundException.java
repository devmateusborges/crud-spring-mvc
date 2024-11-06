package com.fafram.products_crud.utils;

public class SalesProductsNotFoundException extends RuntimeException {
    public SalesProductsNotFoundException(String message) {
        super(message);
    }
}
