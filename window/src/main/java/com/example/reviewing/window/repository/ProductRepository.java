package com.example.reviewing.window.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reviewing.window.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	Optional<Product> findByReference(String reference);
}
