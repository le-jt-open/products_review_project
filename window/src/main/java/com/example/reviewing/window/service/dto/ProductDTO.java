package com.example.reviewing.window.service.dto;

import java.util.List;

public record ProductDTO(
        Long id,
        String reference,
        String name,
        String description,
        Double price,
        Integer stock,
        String currency,
        List<ReviewDTO> reviews
) {}