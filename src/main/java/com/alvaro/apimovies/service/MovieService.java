package com.alvaro.apimovies.service;

import java.util.List;

import com.alvaro.apimovies.dto.MovieDTO;
import com.alvaro.apimovies.dto.ReviewDTO;
import com.alvaro.apimovies.model.Movie;
import com.alvaro.apimovies.projection.MovieProjection;

public interface MovieService {

	Movie createMovie(MovieDTO movieDTO);

	List<MovieProjection> getAllMovies();

	void addReviewToMovie(long movieId, ReviewDTO reviewDTO);

	MovieProjection getMovieById(long movieId);

	MovieProjection getMovieByName(String name);

}
