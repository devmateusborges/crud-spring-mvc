package com.fafram.products_crud.service;

import com.fafram.products_crud.model.SalesProducts;
import com.fafram.products_crud.repository.SalesProductsRepository;
import com.fafram.products_crud.utils.SalesProductsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesProductServiceImpl implements ISalesProductService {

    @Autowired
    private SalesProductsRepository repository;

    @Override
    public SalesProducts saveSalesProducts(SalesProducts salesProducts) {
        return repository.save(salesProducts);
    }

    @Override
    public List<SalesProducts> getAllSalesProducts() {
        return repository.findAll();
    }

    @Override
    public SalesProducts getSalesProductsById(Long id) {
        Optional<SalesProducts> salesProducts = repository.findById(id);
        if (salesProducts.isPresent()) {
            return salesProducts.get();
        } else {
            throw new SalesProductsNotFoundException("SalesProducts with Id: " + id + " Not Found!");
        }
    }

    @Override
    public void updateSalesProducts(SalesProducts salesProducts) {
        repository.save(salesProducts);
    }

    @Override
    public void deleteSalesProductsById(Long id) {
        repository.delete(getSalesProductsById(id));
    }
}
