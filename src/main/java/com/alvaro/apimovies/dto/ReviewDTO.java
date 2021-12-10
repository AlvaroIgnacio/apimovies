package com.alvaro.apimovies.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ReviewDTO {

    @NotBlank(message = "Debe completar el comentario")
    @Size(max = 200, message="El comentario no debe superar los {max} caracteres")
    private String comment;

    @NotBlank(message = "Debe completar el nombre de usuario")
    private String username;

    public ReviewDTO() {
    }

    public String getComment() {
        return this.comment;
    }

    public String getUsername() {
        return this.username;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
