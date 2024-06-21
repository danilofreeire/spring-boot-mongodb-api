package com.social.workshop.domain;

import com.social.workshop.dto.AuthorDTO;
import com.social.workshop.dto.CommentDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Document
public class Post implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private LocalDate date;
    private String title;
    private String body;
    private AuthorDTO authorDto;

    private List<CommentDTO> comments = new ArrayList<>();

    public Post(){

    }

    public Post(String id, LocalDate date, String title, String body, AuthorDTO authorDto) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.authorDto = authorDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
