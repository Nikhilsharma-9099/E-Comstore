package com.infinitiasoft.ecomstore.repositories;

import com.infinitiasoft.ecomstore.modules.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByCategoryName(@NotBlank @Size(min = 5, max = 15, message = "Category name must be between 5 and 15 characters") String categoryName);
}
