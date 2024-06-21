package com.social.workshop.resources;

import com.social.workshop.domain.Post;
import com.social.workshop.domain.User;
import com.social.workshop.dto.UserDTO;
import com.social.workshop.services.UserService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@Log4j2
@RestController
public class UserResource {

    @Autowired
    UserService userService;

    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@RequestBody @Valid  UserDTO userDTO) {
        var user = new User();
        BeanUtils.copyProperties(userDTO, user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") String id) {
        Optional<User> user = userService.findUserById(id);
        if (!user.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully");

    }
    @PutMapping("/users/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable(value = "id") String id,
                                           @RequestBody @Valid UserDTO userDTO) {

        Optional<User> user = userService.findUserById(id);
        if (user.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        var newUser = user.get();
        BeanUtils.copyProperties(userDTO, newUser);

        userService.saveUser(newUser);
        return ResponseEntity.status(HttpStatus.OK).body(newUser);

    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Object> getUser(@PathVariable(value = "id") String id) {
        Optional<User> usr = userService.findUserById(id);
        if(usr.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(usr.get());
    }
    @GetMapping("/users/{id}/posts")
    public ResponseEntity<Object> getPost(@PathVariable(value = "id") String id) {
        Optional<User> usr = userService.findUserById(id);
        if(usr.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(usr.get().getPosts());
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
}
