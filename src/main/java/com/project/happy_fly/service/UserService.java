package com.project.happy_fly.service;

import com.project.happy_fly.model.User;
import com.project.happy_fly.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        Optional<User> existingUser = userRepository.findById(user.getHandle());
        if(existingUser.isPresent()) {
            throw new IllegalArgumentException("Un utilisateur avec ce pseudo existe déjà.");
        }
        return userRepository.save(user);
    }

    public Optional<User> getUser(final String id) {
        return userRepository.findById(id);
    }

    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    public User removeUser(final String handle) {
        User user = userRepository.findById(handle).orElse(null);
        if(user != null){
            userRepository.deleteById(handle);
        }
        return user;
    }
}