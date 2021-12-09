package com.alvaro.apimovies.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alvaro.apimovies.model.Review;
import com.alvaro.apimovies.projection.ReviewProjection;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    ReviewProjection findProjectedById(Long actorId);

}
