package com.fafram.products_crud.repository;

import com.fafram.products_crud.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Product, Long> {
}
