package com.capgemini.cachepractice.service;

import com.capgemini.cachepractice.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto create(ProductDto productDto);

    ProductDto getById(Long id);

    List<ProductDto> getAll();

    ProductDto update(Long id, ProductDto productDto);

    void delete(Long id);
}

