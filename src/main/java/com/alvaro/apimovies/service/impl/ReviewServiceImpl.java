package com.alvaro.apimovies.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alvaro.apimovies.dto.ReviewDTO;
import com.alvaro.apimovies.model.Movie;
import com.alvaro.apimovies.model.Review;
import com.alvaro.apimovies.repository.ReviewRepository;
import com.alvaro.apimovies.service.ReviewService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    private final ObjectMapper mapper;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository, ObjectMapper mapper) {
    	this.reviewRepository = reviewRepository;
    	this.mapper = mapper;
	}
    
    
    @Override
    @Transactional
    public void addReview(Movie movie, ReviewDTO reviewDTO) {
        Review review = mapper.convertValue(reviewDTO,Review.class);
        review.setMovie(movie);
        this.reviewRepository.save(review);
    }

	
}
