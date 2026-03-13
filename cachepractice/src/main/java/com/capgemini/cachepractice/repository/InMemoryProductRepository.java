package com.capgemini.cachepractice.repository;

import com.capgemini.cachepractice.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryProductRepository {

    private final Map<Long, Product> storage = new ConcurrentHashMap<>();

    public Product save(Product product) {
        storage.put(product.getId(), product);
        return product;
    }

    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    public List<Product> findAll() {
        return new ArrayList<>(storage.values());
    }

    public boolean existsById(Long id) {
        return storage.containsKey(id);
    }

    public void deleteById(Long id) {
        storage.remove(id);
    }
}

