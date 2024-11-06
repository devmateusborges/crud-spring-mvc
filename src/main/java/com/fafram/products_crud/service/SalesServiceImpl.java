package com.fafram.products_crud.service;

import com.fafram.products_crud.model.Sales;
import com.fafram.products_crud.repository.SalesRepository;
import com.fafram.products_crud.utils.SalesNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesServiceImpl implements ISalesService {

    @Autowired
    private SalesRepository repository;

    @Override
    public Sales saveSales(Sales sales) {
        return repository.save(sales);
    }

    @Override
    public List<Sales> getAllSales() {
        return repository.findAll();
    }

    @Override
    public Sales getSalesById(Long id) {
        Optional<Sales> sales = repository.findById(id);
        if (sales.isPresent()) {
            return sales.get();
        } else {
            throw new SalesNotFoundException("Sales with Id: " + id + " Not Found!");
        }
    }

    @Override
    public void updateSales(Sales sales) {
        repository.save(sales);
    }

    @Override
    public void deleteSalesById(Long id) {
        repository.delete(getSalesById(id));
    }
}
