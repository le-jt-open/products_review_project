package com.example.reviewing.window.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.reviewing.window.entity.Product;
import com.example.reviewing.window.entity.Review;
import com.example.reviewing.window.service.dto.ProductDTO;

class ProductMapperTest {

    private static final String LAPTOP = "Laptop";

	@Test
    void shouldMapEntityToDTO() {
        Review review = new Review();
        review.setId(1L);
        review.setNotation(5);

        Product product = new Product();
        product.setId(100L);
        product.setName(LAPTOP);
        product.setReviews(List.of(review));

        ProductDTO dto = ProductMapper.toDTO(product);

        assertThat(dto).isNotNull();
        assertThat(dto.id()).isEqualTo(100L);
        assertThat(dto.name()).isEqualTo(LAPTOP);
        assertThat(dto.reviews()).hasSize(1);
    }

    @Test
    void shouldMapDTOToEntity() {
        ProductDTO dto = new ProductDTO(
                100L,
                "REF1",
                LAPTOP,
                "Desc",
                1000.0,
                10,
                "EUR",
                List.of()
        );

        Product product = ProductMapper.toEntity(dto);

        assertThat(product).isNotNull();
        assertThat(product.getId()).isEqualTo(100L);
        assertThat(product.getName()).isEqualTo(LAPTOP);
    }

    @Test
    void shouldHandleNull() {
        assertThat(ProductMapper.toDTO(null)).isNull();
        assertThat(ProductMapper.toEntity(null)).isNull();
    }
}