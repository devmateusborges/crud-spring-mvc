package com.fafram.products_crud.repository;

import com.fafram.products_crud.model.SalesProducts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesProductsRepository extends JpaRepository<SalesProducts, Long> {
}
