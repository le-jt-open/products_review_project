package com.example.reviewing.window.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.reviewing.window.repository.ReviewRepository;
import com.example.reviewing.window.service.impl.ReviewServiceImpl;

@ExtendWith(MockitoExtension.class)
class ReviewServiceTest {

    @Mock
    private ReviewRepository reviewRepository;

    @InjectMocks
    private ReviewServiceImpl reviewService;

    @Test
    void shouldReturnReviewCount() {
        when(reviewRepository.count()).thenReturn(25L);

        long result = reviewService.countReviews();

        assertThat(result).isEqualTo(25);
    }
}