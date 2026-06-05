package com.example.reviewing.window.service.mapper;

import com.example.reviewing.window.entity.Author;
import com.example.reviewing.window.service.dto.AuthorDTO;

public class AuthorMapper {

    public static AuthorDTO toDTO(Author author) {
        if (author == null) return null;

        return new AuthorDTO(
                author.getId(),
                author.getFirstName(),
                author.getLastName(),
                author.getType()
        );
    }

    public static Author toEntity(AuthorDTO dto) {
        if (dto == null) return null;

        Author author = new Author();
        author.setId(dto.id());
        author.setFirstName(dto.firstName());
        author.setLastName(dto.lastName());
        author.setType(dto.type());

        return author;
    }
}