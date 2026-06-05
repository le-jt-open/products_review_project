package com.example.reviewing.window.service.impl;

import org.springframework.stereotype.Service;

import com.example.reviewing.window.repository.ReviewRepository;
import com.example.reviewing.window.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

	@Override
	public long countReviews() {
		return reviewRepository.count();
	}
}