package com.infinitiasoft.ecomstore.services;

import com.infinitiasoft.ecomstore.exceptions.ResourceNotFoundException;
import com.infinitiasoft.ecomstore.modules.Category;
import com.infinitiasoft.ecomstore.modules.Product;
import com.infinitiasoft.ecomstore.payload.ProductDTO;
import com.infinitiasoft.ecomstore.payload.ProductResponse;
import com.infinitiasoft.ecomstore.repositories.CategoryRepository;
import com.infinitiasoft.ecomstore.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductDTO addProduct(Long categoryId, ProductDTO productDTO) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

        // 2. Map DTO to Entity
        Product product = modelMapper.map(productDTO, Product.class);

        // 3. Initialize fields & ensure ID is null for a fresh Insert
        product.setProductId(null);
        product.setImage("default.png");
        product.setCategory(category);

        // 4. Calculate Special Price
        Double specialPrice = product.getProductPrice() - ((product.getDiscount() * 0.01) * product.getProductPrice());
        product.setSpecialPrice(specialPrice);

        // 5. Save and Map back to DTO
        Product savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct, ProductDTO.class);
    }

    @Override
    public ProductResponse getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOList = products.stream().map(product -> modelMapper.map(product, ProductDTO.class))
                .toList();

        ProductResponse productResponse = new ProductResponse();
        productResponse.setContent(productDTOList);
        return productResponse;
    }
}
