package com.example.reviewing.window.service.mapper;

import com.example.reviewing.window.entity.Review;
import com.example.reviewing.window.service.dto.ReviewDTO;

public class ReviewMapper {

    public static ReviewDTO toDTO(Review review) {
        if (review == null) return null;

        return new ReviewDTO(
                review.getId(),
                review.getNotation(),
                review.getDate(),
                review.getComment(),
                AuthorMapper.toDTO(review.getAuthor())
        );
    }

    public static Review toEntity(ReviewDTO dto) {
        if (dto == null) return null;

        Review review = new Review();
        review.setId(dto.id());
        review.setNotation(dto.notation());
        review.setDate(dto.date());
        review.setComment(dto.comment());
        review.setAuthor(AuthorMapper.toEntity(dto.author()));

        return review;
    }
}