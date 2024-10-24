package com.fafram.products_crud.service;

import com.fafram.products_crud.model.Product;

import java.util.List;

public interface IClientService {

    public Product saveProduct(Product product);
    public List<Product> getAllProducts();
    public Product getProductById(Long id);
    public void updateProduct(Product product);
    public void deleteProductById(Long id);
}
