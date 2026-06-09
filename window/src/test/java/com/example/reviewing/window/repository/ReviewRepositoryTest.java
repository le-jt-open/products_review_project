package com.example.reviewing.window.repository;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.reviewing.window.entity.Review;

@DataJpaTest
@ActiveProfiles("test")
class ReviewRepositoryTest {

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    void shouldCountReviews() {
        reviewRepository.save(new Review());
        reviewRepository.save(new Review());
        reviewRepository.save(new Review());

        long count = reviewRepository.count();

        assertThat(count).isEqualTo(3);
    }
}
