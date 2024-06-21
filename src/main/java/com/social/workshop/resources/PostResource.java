package com.social.workshop.resources;

import com.social.workshop.domain.Post;
import com.social.workshop.domain.User;
import com.social.workshop.dto.PostDTO;
import com.social.workshop.resources.util.URL;
import com.social.workshop.services.PostService;

import com.social.workshop.services.UserService;
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
public class PostResource {

    @Autowired
    PostService postService;

    @PostMapping("/posts")
    public ResponseEntity<Post> createPost(@RequestBody @Valid PostDTO postDTO) {

        var post = new Post();
        BeanUtils.copyProperties(postDTO, post);
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.savePost(post));

    }
    
    @GetMapping("/posts/{id}")
    public ResponseEntity<Object> getPost(@PathVariable(value = "id") String id) {
        Optional<Post> pst = postService.findPostById(id);
        if(pst.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pst.get());
    }
    @GetMapping("/posts/titlesearch")
    public ResponseEntity<Object> findByTitle(@RequestParam(value = "text",defaultValue = "")
                                                      String text) {
        text = URL.DECOD_PARAM(text);
        List<Post> pst = postService.findByTitle(text);

        if(pst.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pst);
    }
    @GetMapping("/posts/fullsearch")
    public ResponseEntity<Object> fullSearch(
            @RequestParam(value = "text",defaultValue = "") String text,
            @RequestParam(value = "minDate",defaultValue = "") String minDate,
            @RequestParam(value = "maxDate",defaultValue = "") String maxDate) {
        LocalDate dateDefault= LocalDate.EPOCH;
        text = URL.DECOD_PARAM(text);

        LocalDate min = URL.CONVERT_DATE(minDate,dateDefault);
        LocalDate max = URL.CONVERT_DATE(maxDate,dateDefault);

        List<Post> pst = postService.fullSearch(text,min,max);

        if(pst.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pst);
    }
    
}
