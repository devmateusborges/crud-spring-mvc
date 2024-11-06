package com.fafram.products_crud.repository;

import com.fafram.products_crud.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
