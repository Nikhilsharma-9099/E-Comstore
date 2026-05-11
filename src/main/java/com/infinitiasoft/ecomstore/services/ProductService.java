package com.infinitiasoft.ecomstore.services;

import com.infinitiasoft.ecomstore.modules.Product;
import com.infinitiasoft.ecomstore.payload.ProductDTO;
import com.infinitiasoft.ecomstore.payload.ProductResponse;

public interface ProductService {
    ProductDTO addProduct(Long categoryId, ProductDTO productDTO);

    ProductResponse getAllProducts();

    ProductResponse searchByCategory(Long categoryId);

    ProductResponse searchProductByKeyword(String keyword);

    ProductDTO updateProduct(Long productId, Product product);
}
