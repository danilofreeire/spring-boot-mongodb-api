package com.social.workshop.resources;

import com.social.workshop.domain.Post;
import com.social.workshop.services.PostService;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;


@Log4j2
@RestController
public class PostResource {

    @Autowired
    PostService postService;

    
    @GetMapping("/posts/{id}")
    public ResponseEntity<Object> getPost(@PathVariable(value = "id") String id) {
        Optional<Post> pst = postService.findPostById(id);
        if(pst.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pst.get());
    }
    
}
