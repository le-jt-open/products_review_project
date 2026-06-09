package com.example.reviewing.window.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.example.reviewing.window.entity.Author;
import com.example.reviewing.window.service.dto.AuthorDTO;

class AuthorMapperTest {

    private static final String AMATEUR = "amateur";
	private static final String JANE = "Jane";
	private static final String PROFESSIONAL = "professional";
	private static final String DOE = "Doe";
	private static final String JOHN = "John";

	@Test
    void shouldMapEntityToDTO() {
        Author author = new Author();
        author.setId(1L);
        author.setFirstName(JOHN);
        author.setLastName(DOE);
        author.setType(PROFESSIONAL);

        AuthorDTO dto = AuthorMapper.toDTO(author);

        assertThat(dto).isNotNull();
        assertThat(dto.id()).isEqualTo(1L);
        assertThat(dto.firstName()).isEqualTo(JOHN);
        assertThat(dto.lastName()).isEqualTo(DOE);
        assertThat(dto.type()).isEqualTo(PROFESSIONAL);
    }

    @Test
    void shouldMapDTOToEntity() {
        AuthorDTO dto = new AuthorDTO(
                1L,
                JANE,
                DOE,
                AMATEUR
        );

        Author author = AuthorMapper.toEntity(dto);

        assertThat(author).isNotNull();
        assertThat(author.getId()).isEqualTo(1L);
        assertThat(author.getFirstName()).isEqualTo(JANE);
        assertThat(author.getLastName()).isEqualTo(DOE);
        assertThat(author.getType()).isEqualTo(AMATEUR);
    }

    @Test
    void shouldReturnNullWhenEntityIsNull() {
        assertThat(AuthorMapper.toDTO(null)).isNull();
    }

    @Test
    void shouldReturnNullWhenDTOIsNull() {
        assertThat(AuthorMapper.toEntity(null)).isNull();
    }
}