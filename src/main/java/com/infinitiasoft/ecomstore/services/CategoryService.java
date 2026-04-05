package com.infinitiasoft.ecomstore.services;

import com.infinitiasoft.ecomstore.modules.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    void createCategory(Category category);

    String deleteCategory(Long id);

    Category updateCategory(Category category, Long id);
}
