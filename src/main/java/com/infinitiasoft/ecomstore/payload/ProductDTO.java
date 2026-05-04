package com.infinitiasoft.ecomstore.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long productId;
    private String productName;
    private String image;
    private String productDescription;
    private Integer quantity;
    private Double productPrice;
    private Double discount;
    private Double specialPrice;
}
