package com.infinitiasoft.ecomstore.modules;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @NotBlank
    @Size(min = 3, max = 300, message = "Product name must be between 3 and 30 characters")
    private String productName;

    @NotBlank
    @Size(min = 5, max = 300, message = "Product description must be between 5 and 30 characters")
    private String productDescription;
    private Integer quantity;
    private String image;
    private Double productPrice;
    private Double discount;
    private Double specialPrice;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
