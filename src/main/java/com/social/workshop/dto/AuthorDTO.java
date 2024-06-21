package com.social.workshop.dto;

import com.social.workshop.domain.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public record AuthorDTO(@NotNull String id, @NotBlank String name) implements Serializable {
    private static final long serialVersionUID = 1L;


    public AuthorDTO(User user){
        this(user.getId(),user.getName());
    }
}
