package com.fafram.products_crud.service;

import com.fafram.products_crud.model.Category;
import com.fafram.products_crud.repository.CategoryRepository;
import com.fafram.products_crud.utils.CategoryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryRepository repository;

    @Override
    public Category saveCategory(Category category) {
        return repository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return repository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        Optional<Category> category = repository.findById(id);
        if (category.isPresent()) {
            return category.get();
        } else {
            throw new CategoryNotFoundException("Category with Id: " + id + " Not Found!");
        }
    }

    @Override
    public void updateCategory(Category category) {
        repository.save(category);
    }

    @Override
    public void deleteCategoryById(Long id) {
        repository.delete(getCategoryById(id));
    }
}
