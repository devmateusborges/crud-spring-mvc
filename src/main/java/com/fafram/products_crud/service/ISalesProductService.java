package com.fafram.products_crud.service;

import com.fafram.products_crud.model.SalesProducts;

import java.util.List;

public interface ISalesProductService {
    SalesProducts saveSalesProducts(SalesProducts salesProducts);
    List<SalesProducts> getAllSalesProducts();
    SalesProducts getSalesProductsById(Long id);
    void updateSalesProducts(SalesProducts salesProducts);
    void deleteSalesProductsById(Long id);
}
