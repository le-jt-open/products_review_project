package com.example.reviewing.window.service;

import java.util.List;

import com.example.reviewing.window.service.dto.ProductDTO;


public interface ProductService {

    List<ProductDTO> getAllProducts();

    ProductDTO getProductById(Long id);
    
    /**
     * Returns top 5 products with the best ratings.
     * @return
     */
    List<ProductDTO> getHighestRated();
    
    /**
     * Returns top 5 products with the worst ratings.
     * @return
     */
    List<ProductDTO> getLowestRated();
    
    
    /**
     * Returns the total number of products.
     * @return
     */
    long countProducts();

}