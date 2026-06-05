package com.example.reviewing.window.service.dto;

public record AuthorDTO(
        Long id,
        String firstName,
        String lastName,
        String type
) {}