package com.social.workshop.resources;

import com.social.workshop.domain.Comment;
import com.social.workshop.domain.Post;
import com.social.workshop.dto.CommentDTO;
import com.social.workshop.dto.PostDTO;
import com.social.workshop.repository.CommentRepository;
import com.social.workshop.resources.util.URL;
import com.social.workshop.services.CommentService;
import com.social.workshop.services.CommentService;
import com.social.workshop.services.PostService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Log4j2
@RestController
public class CommentResource {

    @Autowired
    CommentService commentService;

    @Autowired
    PostService postService;

    @PostMapping("/{id}/comments")
    public ResponseEntity<Post> createComment(@PathVariable(value = "id") String postId,
                                              @RequestBody @Valid CommentDTO commentDTO) {
        Post post = postService.addCommentToPost(postId, commentDTO);
        var comment = new Comment();
        BeanUtils.copyProperties(commentDTO, comment);
        commentService.saveComment(comment);
        return ResponseEntity.status(HttpStatus.CREATED).body(post);
    }

    @GetMapping("/comments/{id}")
    public ResponseEntity<Object> getComment(@PathVariable(value = "id") String id) {
        Optional<Comment> cmt = commentService.findCommentById(id);
        if(cmt.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Comment not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(cmt.get());
    }
    

    
}
