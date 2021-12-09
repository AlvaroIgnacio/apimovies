package com.alvaro.apimovies.projection;

import java.util.List;

public interface MovieProjection {
    Long getId();
    String getName();
    Integer getRanking();
    List<ActorProjection> getActors();
    List<ReviewProjection> getReviews();
}
