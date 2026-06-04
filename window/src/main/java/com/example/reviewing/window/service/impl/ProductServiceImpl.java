package com.example.reviewing.window.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.reviewing.window.entity.Product;
import com.example.reviewing.window.repository.ProductRepository;
import com.example.reviewing.window.service.ProductService;
import com.example.reviewing.window.service.dto.ProductDTO;
import com.example.reviewing.window.service.mapper.ProductMapper;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(ProductMapper::toDTO)
                .toList();
    }

    @Override
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));

        return ProductMapper.toDTO(product);
    }

	@Override
	public List<ProductDTO> getHighestRated() {
		return productRepository.findTop5BestRatedProducts()
				.stream()
				.map(ProductMapper::toDTO)
				.toList();
	}

	@Override
	public List<ProductDTO> getLowestRated() {
		return productRepository.findTop5WorstRatedProducts()
				.stream()
				.map(ProductMapper::toDTO)
				.toList();
	}

	@Override
	public long countProducts() {
		return productRepository.count();
	}
}