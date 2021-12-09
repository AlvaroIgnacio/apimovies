package com.alvaro.apimovies.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alvaro.apimovies.dto.MovieDTO;
import com.alvaro.apimovies.dto.ReviewDTO;
import com.alvaro.apimovies.model.Movie;
import com.alvaro.apimovies.projection.MovieProjection;
import com.alvaro.apimovies.service.MovieService;

@RequestMapping(value = "/movies")
@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping
    public ResponseEntity<Object> createMovie( @Valid @RequestBody MovieDTO movieDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(
                    bindingResult.getAllErrors().stream().map( e -> e.getDefaultMessage()).collect(Collectors.toList()),
                    HttpStatus.BAD_REQUEST);
        }

        Movie movieCreate = movieService.createMovie(movieDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(movieCreate.getId());
    }

    @PutMapping(value = "/{movieId}")
    public ResponseEntity<Object> addReviewToMovie(@PathVariable long movieId, @Valid @RequestBody ReviewDTO reviewDTO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(
                    bindingResult.getAllErrors().stream().map( e -> e.getDefaultMessage()).collect(Collectors.toList()),
                    HttpStatus.BAD_REQUEST);
        }

        movieService.addReviewToMovie(movieId, reviewDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<MovieProjection>> getMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<MovieProjection> getDetailMovie(@PathVariable long movieId){
        return ResponseEntity.ok(movieService.getMovieById(movieId));
    }
  
    
    /*
    @GetMapping("/{movieId}")
    public ResponseEntity<MovieModelAssembler> getDetailMovie(@PathVariable long movieId){
        return ResponseEntity.ok(movieService.getDetailMovie(movieId));
    }*/
}
