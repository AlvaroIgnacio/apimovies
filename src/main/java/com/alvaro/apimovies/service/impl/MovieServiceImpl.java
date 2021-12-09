package com.alvaro.apimovies.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alvaro.apimovies.dto.MovieDTO;
import com.alvaro.apimovies.dto.ReviewDTO;
import com.alvaro.apimovies.model.Movie;
import com.alvaro.apimovies.projection.MovieProjection;
import com.alvaro.apimovies.repository.MovieRepository;
import com.alvaro.apimovies.service.MovieService;
import com.alvaro.apimovies.service.ReviewService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MovieServiceImpl implements MovieService {

    private final ObjectMapper mapper;
    private final MovieRepository movieRepository;
    private final ReviewService reviewService;

    @Autowired
    MovieServiceImpl(MovieRepository movieRepo, ObjectMapper mapper, ReviewService reviewService) {
        this.movieRepository = movieRepo;
        this.mapper = mapper;
        this.reviewService = reviewService;
    }

    @Override
    @Transactional
    public Movie createMovie(MovieDTO movieDTO) {
        Movie movie = mapper.convertValue(movieDTO, Movie.class);
        return movieRepository.save(movie);
    }

    @Override
    public List<MovieProjection> getAllMovies() {
        return movieRepository.findAllProjectBy();
    }

    @Override
    @Transactional
    public void addReviewToMovie(long movieId, ReviewDTO reviewDTO) {
        Movie movie = movieRepository.findById(movieId)
        		.orElseThrow(() -> new RuntimeException("No existe una película con el id especificado"));
        reviewService.addReview(movie,reviewDTO);
    }    
    
	@Override
    public MovieProjection getMovieById(long movieId) {
        return movieRepository.findProjectedById(movieId);
    }

    @Override
    public MovieProjection getMovieByName(String name) {
        return movieRepository.findProjectedByName(name);
    }

}
