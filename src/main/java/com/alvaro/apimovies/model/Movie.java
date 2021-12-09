package com.alvaro.apimovies.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false, length = 200)
    private String name;

    @Column(nullable = false)
    private Integer ranking;
    
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "movie_actor",
            joinColumns = {@JoinColumn(name = "movie_id")},
            uniqueConstraints = { @UniqueConstraint(columnNames = {"movie_id", "actor_id" }) },
            inverseJoinColumns = {@JoinColumn(name = "actor_id")})
    private List<Actor> actors = new ArrayList<>();

    @OneToMany(mappedBy = "movie")
    List<Review> reviews = new ArrayList<>();

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Integer getRanking() {
        return this.ranking;
    }

    public List<Actor> getActors() {
        return this.actors;
    }

    public List<Review> getReviews() {
        return this.reviews;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;

    }
    
}