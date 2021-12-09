package com.alvaro.apimovies.dto;

import javax.validation.constraints.NotBlank;

public class ActorDTO {

    @NotBlank(message = "Debe completar el apellido")
    private String lastName;  
    
    @NotBlank(message = "Debe completar el nombre")
    private String name;
    
    public ActorDTO() {
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getName() {
        return this.name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
