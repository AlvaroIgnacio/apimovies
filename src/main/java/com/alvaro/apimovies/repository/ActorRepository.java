package com.alvaro.apimovies.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alvaro.apimovies.model.Actor;
import com.alvaro.apimovies.projection.ActorProjection;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

    Page<ActorProjection> findAllPagedBy(Pageable page);

    ActorProjection findProjectedById(Long actorId);

	Page<ActorProjection> findByLastNameIgnoreCase(Pageable page, String lastName);
    
}
