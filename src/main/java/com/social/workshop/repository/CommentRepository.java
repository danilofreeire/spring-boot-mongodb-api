package com.social.workshop.repository;

import com.social.workshop.domain.Comment;
import com.social.workshop.domain.User;
import com.social.workshop.dto.CommentDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {
}
