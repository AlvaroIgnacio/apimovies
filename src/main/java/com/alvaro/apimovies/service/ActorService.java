package com.alvaro.apimovies.service;

import org.springframework.data.domain.Page;

import com.alvaro.apimovies.projection.ActorProjection;

public interface ActorService {

	Page<ActorProjection> findByLastName(int page, int size, String lastName);

}
