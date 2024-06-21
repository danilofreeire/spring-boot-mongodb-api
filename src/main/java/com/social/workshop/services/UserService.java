package com.social.workshop.services;

import com.social.workshop.domain.Post;
import com.social.workshop.domain.User;
import com.social.workshop.dto.UserDTO;
import com.social.workshop.repository.UserRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public User saveUser(User user){
        return userRepository.save(user);
    }
    public void deleteUser(String id){
        userRepository.deleteById(id);
    }

    public User addPostToUser(String userId, Post post) {
        Optional<User> userOpt = findUserById(userId);
        User user = userOpt.get();
        user.getPosts().add(post);
        return userRepository.save(user);
    }

    public Optional<User> findUserById(@NotNull String id) {
        Optional<User> user = userRepository.findById(id);
        return user;
    }
    public List<User> findAll() {
        return userRepository.findAll();
    }

}
