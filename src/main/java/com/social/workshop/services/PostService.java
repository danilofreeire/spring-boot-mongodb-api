package com.social.workshop.services;

import com.social.workshop.domain.Comment;
import com.social.workshop.domain.Post;
import com.social.workshop.domain.User;
import com.social.workshop.dto.CommentDTO;
import com.social.workshop.dto.PostDTO;
import com.social.workshop.repository.PostRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserService userService;

    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    public Post createPostForUser(String userId, PostDTO postDTO) {
        var post = new Post();
        BeanUtils.copyProperties(postDTO, post);
        post = savePost(post);
        userService.addPostToUser(userId, post);
        return post;
    }
    public Post addCommentToPost(String postId, CommentDTO commentDTO) {
        Optional<Post> postOpt = findPostById(postId);
        Post post = postOpt.get();
        post.getComments().add(commentDTO);
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
