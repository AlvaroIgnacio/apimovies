package com.alvaro.apimovies.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MovieDTO {
    
    @NotBlank(message = "Debe completar el nombre")
    @Size(max = 50, message="El nombre como máximo debe tener {max} caracteres")
    private String name;

    @NotNull(message = "Debe completar un valor de ranking")
    @Min(value = 1, message="Debe ser como mínimo 1")
    @Max(value = 10, message="Debe ser como máximo 10")
    private Integer ranking;

    @Valid
    @NotEmpty(message = "Debe completar la lista de actores ")
    private List<ActorDTO> actors;

    public MovieDTO() {
    }

    public String getName() {
        return this.name;
    }

    public Integer getRanking() {
        return this.ranking;
    }

    public List<ActorDTO> getActors() {
        return this.actors;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public void setActors(List<ActorDTO> actors) {
        this.actors = actors;
    }
    
}