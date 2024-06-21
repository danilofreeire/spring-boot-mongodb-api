package com.social.workshop.services;

import com.social.workshop.domain.Post;
import com.social.workshop.repository.PostRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public Post savePost(Post post) {
        return postRepository.save(post);
    }
    public Optional<Post> findPostById(@NotNull String id) {
        Optional<Post> post = postRepository.findById(id);
        return post;
    }

    public List<Post> findByTitle(@NotNull String title) {
        return postRepository.findByTitle(title);
    }
    public List<Post> fullSearch(@NotNull String text ,@NotNull LocalDate minDate, @NotNull LocalDate maxDate) {
        maxDate.plusDays(1);
        return postRepository.fullSearch(text, minDate, maxDate);
    }


}
