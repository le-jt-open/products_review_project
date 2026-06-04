package com.example.reviewing.window.service;

import java.util.List;

import com.example.reviewing.window.service.dto.ProductDTO;

public interface ProductService {

    List<ProductDTO> getAllProducts();

    ProductDTO getProductById(Long id);

    ProductDTO createProduct(ProductDTO productDTO);

    void deleteProduct(Long id);
}