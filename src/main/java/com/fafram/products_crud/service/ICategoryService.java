package com.fafram.products_crud.service;

import com.fafram.products_crud.model.Category;

import java.util.List;

public interface ICategoryService {
    Category saveCategory(Category category);
    List<Category> getAllCategories();
    Category getCategoryById(Long id);
    void updateCategory(Category category);
    void deleteCategoryById(Long id);
}
