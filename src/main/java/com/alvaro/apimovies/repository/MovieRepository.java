package com.alvaro.apimovies.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alvaro.apimovies.model.Movie;
import com.alvaro.apimovies.projection.MovieProjection;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    
    List<MovieProjection> findAllProjectBy();
    
    MovieProjection findProjectedById(Long movieId);

    MovieProjection findProjectedByName(String name);
}
