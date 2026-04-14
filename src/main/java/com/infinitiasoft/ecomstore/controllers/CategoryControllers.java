package com.infinitiasoft.ecomstore.controllers;

import com.infinitiasoft.ecomstore.modules.Category;
import com.infinitiasoft.ecomstore.payload.CategoryDTO;
import com.infinitiasoft.ecomstore.payload.CategoryResponse;
import com.infinitiasoft.ecomstore.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryControllers {

    @Autowired
    private CategoryService categoryService;

    public CategoryControllers(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/public/categories")
    public ResponseEntity<CategoryResponse> getAllCategories() {
        CategoryResponse categoryResponse = categoryService.getAllCategories();
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }

    @PostMapping("/public/categories")
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO savedCategoryDTO = categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(savedCategoryDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/categories/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        String status = categoryService.deleteCategory(id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PutMapping("/public/categories/{id}")
    public ResponseEntity<String> updateCategory(@Valid @RequestBody Category category, @PathVariable Long id) {
        Category updatedCategory = categoryService.updateCategory(category, id);
        return new ResponseEntity<>("Category with Id : " + id + " Has been updated!!", HttpStatus.OK);
    }

}
