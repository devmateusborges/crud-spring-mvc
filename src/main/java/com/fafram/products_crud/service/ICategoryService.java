package com.fafram.products_crud.service;

import com.fafram.products_crud.model.Category;

import java.util.List;

public interface ICategoryService {

    public Category saveCategory(Category category);

    public List<Category> getAllCategories();

    public Category getCategoryById(Long id);

    public void updateCategory(Category category);

    public void deleteCategoryById(Long id);
}
