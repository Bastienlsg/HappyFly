package com.project.happy_fly.configuration;

import com.project.happy_fly.model.User;
import com.project.happy_fly.repository.UserRepository;

import java.time.LocalDate;
import java.time.Month;

public class UserInitializer {
    private final UserRepository userRepository;

    public UserInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void initializeUsers() {
        User user = new User("utilisateur", "Liza", "Beaudoin", LocalDate.of(1983, Month.JUNE, 13), "utlisateur@gmail.com", "Utilisateur@", false, null);
        User userAdmin = new User("admin", "Alexis", "Clavette", LocalDate.of(1950, Month.SEPTEMBER, 29), "admin@gmail.com", "Administrateur@", true, null);
        this.userRepository.save(user);
        this.userRepository.save(userAdmin);
    }
}
