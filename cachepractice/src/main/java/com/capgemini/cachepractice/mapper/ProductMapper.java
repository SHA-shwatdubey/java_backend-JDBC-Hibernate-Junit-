package com.capgemini.cachepractice.mapper;

import com.capgemini.cachepractice.dto.ProductDto;
import com.capgemini.cachepractice.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductDto toDto(Product product) {
        return new ProductDto(product.getId(), product.getName(), product.getPrice());
    }

    public Product toEntity(ProductDto productDto) {
        return new Product(productDto.getId(), productDto.getName(), productDto.getPrice());
    }
}

