package com.infinitiasoft.ecomstore.modules;

import jakarta.persistence.*;
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
    private String productName;
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
