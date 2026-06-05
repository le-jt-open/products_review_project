package com.example.reviewing.window.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reviewing.window.entity.Product;
import com.example.reviewing.window.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
	List<Review> findByProduct(Product product);
	
	List<Review> findByNotationGreaterThanEqual(int notation);
	
	long count();
}
