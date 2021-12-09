package com.alvaro.apimovies.service;

import com.alvaro.apimovies.dto.ReviewDTO;
import com.alvaro.apimovies.model.Movie;

public interface ReviewService {

	void addReview(Movie movie, ReviewDTO reviewDTO);
	
}
