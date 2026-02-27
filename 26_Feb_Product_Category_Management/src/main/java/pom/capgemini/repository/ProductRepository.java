package pom.capgemini.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pom.capgemini.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByProductNameContainingIgnoreCase(String productName);
    Page<Product> findByProductNameContainingIgnoreCase(String productName, Pageable pageable);

    List<Product> findByCategoryCategoryId(Long categoryId);
    Page<Product> findByCategoryCategoryId(Long categoryId, Pageable pageable);
}

