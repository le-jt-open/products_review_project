package com.example.reviewing.window.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reviewing.window.service.ProductService;
import com.example.reviewing.window.service.dto.ProductDTO;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping("/rating/lowest")
    public ResponseEntity<List<ProductDTO>> getLowestRated() {
    	return ResponseEntity.ok(productService.getLowestRated());
    }

    @GetMapping("/rating/highest")
    public ResponseEntity<List<ProductDTO>> getHighestRated() {
    	return ResponseEntity.ok(productService.getHighestRated());
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
    	return ResponseEntity.ok(productService.countProducts());
    }
}