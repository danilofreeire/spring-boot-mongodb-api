package com.social.workshop.services;

import com.social.workshop.domain.Comment;
import com.social.workshop.dto.CommentDTO;
import com.social.workshop.repository.CommentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }
    public Optional<Comment> findCommentById(String id) {
        Optional<Comment> comment = commentRepository.findById(id);
        return comment;
    }

    


}
