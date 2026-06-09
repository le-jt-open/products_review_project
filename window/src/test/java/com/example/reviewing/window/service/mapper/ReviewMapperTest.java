package com.example.reviewing.window.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.example.reviewing.window.entity.Author;
import com.example.reviewing.window.entity.Review;
import com.example.reviewing.window.service.dto.AuthorDTO;
import com.example.reviewing.window.service.dto.ReviewDTO;

class ReviewMapperTest {

    private static final String GOOD = "Good";
	private static final String JOHN = "John";

	@Test
    void shouldMapEntityToDTO() {
        Author author = new Author();
        author.setId(1L);
        author.setFirstName(JOHN);

        Review review = new Review();
        review.setId(10L);
        review.setNotation(5);
        review.setDate(LocalDateTime.now());
        review.setComment(GOOD);
        review.setAuthor(author);

        ReviewDTO dto = ReviewMapper.toDTO(review);

        assertThat(dto).isNotNull();
        assertThat(dto.id()).isEqualTo(10L);
        assertThat(dto.notation()).isEqualTo(5);
        assertThat(dto.author()).isNotNull();
        assertThat(dto.author().firstName()).isEqualTo(JOHN);
    }

    @Test
    void shouldMapDTOToEntity() {
        AuthorDTO authorDTO = new AuthorDTO(1L, JOHN, "Doe", "professional");

        ReviewDTO dto = new ReviewDTO(
                10L,
                4,
                LocalDateTime.now(),
                "Nice",
                authorDTO
        );

        Review review = ReviewMapper.toEntity(dto);

        assertThat(review).isNotNull();
        assertThat(review.getId()).isEqualTo(10L);
        assertThat(review.getNotation()).isEqualTo(4);
        assertThat(review.getAuthor()).isNotNull();
        assertThat(review.getAuthor().getFirstName()).isEqualTo(JOHN);
    }

    @Test
    void shouldHandleNull() {
        assertThat(ReviewMapper.toDTO(null)).isNull();
        assertThat(ReviewMapper.toEntity(null)).isNull();
    }
}