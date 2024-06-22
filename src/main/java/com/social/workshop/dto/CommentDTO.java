package com.social.workshop.dto;

import com.social.workshop.domain.Comment;
import com.social.workshop.domain.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDate;

public record CommentDTO( @NotBlank String text,  @NotNull LocalDate date, @NotNull AuthorDTO authorDTO ) implements Serializable {
    private static final long serialVersionUID = 1L;
    public CommentDTO(Comment comment){
        this(comment.getText(), comment.getDate(),comment.getAuthorDTO());
    }


}