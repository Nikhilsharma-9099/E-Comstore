package com.infinitiasoft.ecomstore.services;

import com.infinitiasoft.ecomstore.modules.Category;
import com.infinitiasoft.ecomstore.payload.CategoryDTO;
import com.infinitiasoft.ecomstore.payload.CategoryResponse;

public interface CategoryService {
    CategoryResponse getAllCategories();
    CategoryDTO createCategory(CategoryDTO categoryDTO);

    String deleteCategory(Long id);

    Category updateCategory(Category category, Long id);
}
