package com.capgemini.cachepractice.service.impl;

import com.capgemini.cachepractice.dto.ProductDto;
import com.capgemini.cachepractice.entity.Product;
import com.capgemini.cachepractice.exception.ProductNotFoundException;
import com.capgemini.cachepractice.mapper.ProductMapper;
import com.capgemini.cachepractice.repository.InMemoryProductRepository;
import com.capgemini.cachepractice.service.ProductService;
import com.capgemini.cachepractice.service.cache.CacheNames;
import com.capgemini.cachepractice.util.IdGeneratorUtil;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final InMemoryProductRepository productRepository;
    private final ProductMapper productMapper;
    private final IdGeneratorUtil idGeneratorUtil;

    public ProductServiceImpl(InMemoryProductRepository productRepository,
                              ProductMapper productMapper,
                              IdGeneratorUtil idGeneratorUtil) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.idGeneratorUtil = idGeneratorUtil;
    }

    @Override
    @CachePut(value = CacheNames.PRODUCT_BY_ID, key = "#result.id")
    @CacheEvict(value = CacheNames.PRODUCT_LIST, allEntries = true)
    public ProductDto create(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        product.setId(idGeneratorUtil.nextId());
        Product savedProduct = productRepository.save(product);
        return productMapper.toDto(savedProduct);
    }

    @Override
    @Cacheable(value = CacheNames.PRODUCT_BY_ID, key = "#id")
    public ProductDto getById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        return productMapper.toDto(product);
    }

    @Override
    @Cacheable(value = CacheNames.PRODUCT_LIST)
    public List<ProductDto> getAll() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toDto)
                .toList();
    }

    @Override
    @CachePut(value = CacheNames.PRODUCT_BY_ID, key = "#id")
    @CacheEvict(value = CacheNames.PRODUCT_LIST, allEntries = true)
    public ProductDto update(Long id, ProductDto productDto) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException(id);
        }

        Product productToUpdate = productMapper.toEntity(productDto);
        productToUpdate.setId(id);
        Product updated = productRepository.save(productToUpdate);
        return productMapper.toDto(updated);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = CacheNames.PRODUCT_BY_ID, key = "#id"),
            @CacheEvict(value = CacheNames.PRODUCT_LIST, allEntries = true)
    })
    public void delete(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException(id);
        }
        productRepository.deleteById(id);
    }
}
