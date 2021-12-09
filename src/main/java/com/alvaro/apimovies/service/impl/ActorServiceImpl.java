package com.alvaro.apimovies.service.impl;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.alvaro.apimovies.projection.ActorProjection;
import com.alvaro.apimovies.repository.ActorRepository;
import com.alvaro.apimovies.service.ActorService;

@Service
public class ActorServiceImpl implements ActorService {

	private final ActorRepository actorRepository;
	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	ActorServiceImpl(ActorRepository actorRepo) {
		this.actorRepository = actorRepo;
	}

	public Page<ActorProjection> findByLastName(int pageNumber, int size, String lastName){
		Pageable page = PageRequest.of(pageNumber, size);
        if(Objects.isNull(lastName) || lastName.trim().length()==0) {
            return this.actorRepository.findAllPagedBy(page);        	
        } else {
        	return actorRepository.findByLastNameIgnoreCase(page, lastName);	        	
        }
	}

}
