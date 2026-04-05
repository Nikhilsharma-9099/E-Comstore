package com.infinitiasoft.ecomstore.services;

import com.infinitiasoft.ecomstore.modules.Category;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.stream;

@Service
public class CategoryServiceImpl implements CategoryService {
    private List<Category> categories = new ArrayList<>();
    private Long id = 1L;


    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        category.setId(id++);
        categories.add(category);
    }

    @Override
    public String deleteCategory(Long id) {
        Category category = categories.stream().filter(c -> c.getId().equals(id))
                .findFirst().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found!!"));
        categories.remove(category);
        return "Category with Id : " + id + " deleted successfully!";
    }

    @Override
    public Category updateCategory(Category category, Long id) {
            Optional<Category> optionalCategory = categories.stream().filter(c -> c.getId().equals(id))
                .findFirst();

            if(optionalCategory.isPresent()){
                Category existingCategory = optionalCategory.get();
                existingCategory.setName(category.getName());
                return existingCategory;
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found!!");
            }
    }
}
