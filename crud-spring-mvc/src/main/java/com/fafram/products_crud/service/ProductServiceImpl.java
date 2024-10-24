package com.fafram.products_crud.service;

import com.fafram.products_crud.model.Product;
import com.fafram.products_crud.repository.ProductRepository;
import com.fafram.products_crud.utils.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> product = repository.findById(id);
        if (product.isPresent()) {
            return product.get();
        } else {
            throw new ProductNotFoundException("Product with Id: " + id + " Not Found!");
        }
    }

    @Override
    public void updateProduct(Product product) {
        repository.save(product);
    }

    @Override
    public void deleteProductById(Long id) {
        repository.delete(getProductById(id));
    }
}
