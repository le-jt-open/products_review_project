package com.example.reviewing.window.service.dto;

import java.time.LocalDateTime;

public record ReviewDTO(
        Long id,
        Integer notation,
        LocalDateTime date,
        String comment,
        AuthorDTO author
) {}