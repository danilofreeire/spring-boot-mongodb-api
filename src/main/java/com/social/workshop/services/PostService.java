package com.social.workshop.services;

import com.social.workshop.domain.Post;
import com.social.workshop.repository.PostRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public Optional<Post> findPostById(@NotNull String id) {
        Optional<Post> post = postRepository.findById(id);
        return post;
    }


}
