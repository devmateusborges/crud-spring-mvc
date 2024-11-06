package com.fafram.products_crud.service;

import com.fafram.products_crud.model.Sales;

import java.util.List;

public interface ISalesService {
    Sales saveSales(Sales sales);
    List<Sales> getAllSales();
    Sales getSalesById(Long id);
    void updateSales(Sales sales);
    void deleteSalesById(Long id);
}
