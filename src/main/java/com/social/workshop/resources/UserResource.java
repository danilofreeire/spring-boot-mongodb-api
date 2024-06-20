package com.social.workshop.resources;

import com.social.workshop.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class UserResource {

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        User maria = new User("1001", "Maria Brown", "maria@gmail.com");
        User alex = new User("1002", "Alex Green", "alex@gmail.com");
        List<User> users = new ArrayList<>(Arrays.asList(maria, alex));
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
}
