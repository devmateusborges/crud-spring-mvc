package com.fafram.products_crud.repository;

import com.fafram.products_crud.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<Sales, Long> {
}
