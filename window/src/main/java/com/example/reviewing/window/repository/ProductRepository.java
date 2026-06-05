package com.example.reviewing.window.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.reviewing.window.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

@Query("""
        SELECT p FROM Product p
        JOIN p.reviews r
        WHERE r.notation > 3
        GROUP BY p
        ORDER BY AVG(r.notation) DESC
        LIMIT 5
    """)
    List<Product> findTop5BestRatedProducts();

@Query("""
       SELECT p FROM Product p
       JOIN p.reviews r
       GROUP BY p
       ORDER BY AVG(r.notation) ASC
       LIMIT 5
   """)
   List<Product> findTop5WorstRatedProducts();

}
