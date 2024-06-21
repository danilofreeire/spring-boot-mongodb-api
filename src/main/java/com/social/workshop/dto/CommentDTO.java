package com.social.workshop.dto;

import com.social.workshop.domain.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDate;

public record CommentDTO(@NotBlank String text,  LocalDate date, @NotNull AuthorDTO authorDTO) implements Serializable {
    private static final long serialVersionUID = 1L;

}
