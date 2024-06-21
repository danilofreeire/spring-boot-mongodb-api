package com.social.workshop.services;

import com.social.workshop.domain.User;
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
    public Optional<User> findUserById(@NotNull String id) {
        Optional<User> user = userRepository.findById(id);
        return user;
    }
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
