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

    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(final String id) {
        return userRepository.findById(id);
    }

    public void createUser(User user) {
        Optional<User> existingUser = userRepository.findById(user.getHandle());
        if(existingUser.isPresent()) {
            throw new IllegalArgumentException("Un utilisateur avec ce pseudo existe déjà.");
        }
        userRepository.save(user);
    }

    public void removeUser(final String handle) {
        userRepository.findById(handle).ifPresent(user -> userRepository.deleteById(handle));
    }
}