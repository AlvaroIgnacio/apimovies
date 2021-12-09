package com.alvaro.apimovies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alvaro.apimovies.projection.ActorProjection;
import com.alvaro.apimovies.service.ActorService;

@RequestMapping(value = "/actors")
@RestController
public class ActorController {

    private final ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public ResponseEntity<List<ActorProjection>> getActors(@RequestParam int page,
                                                 @RequestParam int size,
                                                 @RequestParam(required = false) String lastName) {        
        
        Page<ActorProjection> pageActors = actorService.findByLastName(page, size, lastName);

        return ResponseEntity.ok(pageActors.getContent());
    }	
}
