package com.social.workshop.services;

import com.social.workshop.domain.Comment;
import com.social.workshop.domain.Post;
import com.social.workshop.dto.CommentDTO;
import com.social.workshop.dto.PostDTO;
import com.social.workshop.repository.CommentRepository;

import com.social.workshop.repository.PostRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;



    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }
    public Optional<Comment> findCommentById(String id) {
        Optional<Comment> comment = commentRepository.findById(id);
        return comment;
    }
    public Comment addCommentToPost(String postId, CommentDTO commentDTO) {
        Optional<Post> postOpt = postRepository.findById(postId);

        Post post = postOpt.get();

        Comment comment = new Comment();

        BeanUtils.copyProperties(commentDTO, comment);
        comment = saveComment(comment);
        CommentDTO commentDTOWithId = new CommentDTO(comment.getText(), comment.getDate(), comment.getAuthorDTO());
        post.getComments().add(commentDTOWithId);
        postRepository.save(post);

        return comment;
    }
    


}
