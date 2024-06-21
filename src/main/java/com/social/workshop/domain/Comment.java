package com.social.workshop.domain;

import com.social.workshop.dto.AuthorDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Document
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String text;
    private LocalDate date;
    private AuthorDTO authorDTO;

    public Comment() {

    }
    public Comment(String id, String text, LocalDate date, AuthorDTO authorDTO) {
        this.id = id;
        this.text = text;
        this.date = date;
        this.authorDTO = authorDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
