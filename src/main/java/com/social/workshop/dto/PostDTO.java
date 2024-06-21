package com.social.workshop.dto;

import com.social.workshop.domain.Post;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public record PostDTO(@NotNull LocalDate date,
                      @NotBlank String title, @NotBlank String body,
                      @NotNull AuthorDTO authorDto,  List<CommentDTO> comments) implements Serializable {
    private static final long serialVersionUID = 1L;

    public  PostDTO(Post post){
        this(post.getDate(), post.getTitle(), post.getBody(), post.getAuthorDto(), post.getComments());
    }
}
