package com.fafram.products_crud.service;

import com.fafram.products_crud.model.Product;

import java.util.List;

public class ClientServiceImpl implements IClientService{
    @Override
    public Product saveProduct(Product product) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product getProductById(Long id) {
        return null;
    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public void deleteProductById(Long id) {

    }
}
