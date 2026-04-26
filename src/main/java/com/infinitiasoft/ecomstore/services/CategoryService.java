package com.infinitiasoft.ecomstore.services;

import com.infinitiasoft.ecomstore.payload.CategoryDTO;
import com.infinitiasoft.ecomstore.payload.CategoryResponse;

public interface CategoryService {
    CategoryResponse getAllCategories(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);
    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO deleteCategory(Long id);

    CategoryDTO updateCategory(CategoryDTO categoryDTO, Long id);
}
