package com.example.reviewing.window.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.example.reviewing.window.entity.Product;
import com.example.reviewing.window.service.dto.ProductDTO;

public class ProductMapper {

    public static ProductDTO toDTO(Product product) {
        if (product == null) return null;

        return new ProductDTO(
                product.getId(),
                product.getReference(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock(),
                product.getCurrency(),
                product.getReviews() != null
                        ? product.getReviews()
                                .stream()
                                .map(ReviewMapper::toDTO)
                                .collect(Collectors.toList())
                        : List.of()
        );
    }

    public static Product toEntity(ProductDTO dto) {
        if (dto == null) return null;

        Product product = new Product();
        product.setId(dto.id());
        product.setReference(dto.reference());
        product.setName(dto.name());
        product.setDescription(dto.description());
        product.setPrice(dto.price());
        product.setStock(dto.stock());
        product.setCurrency(dto.currency());
        return product;
    }
}