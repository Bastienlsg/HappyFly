package com.project.happy_fly.configuration;

import com.project.happy_fly.model.User;
import com.project.happy_fly.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.Month;

public class DatabaseData {
    @Bean
    public CommandLineRunner initData(UserRepository userRepository) {
        return args -> {
            User user = new User("utilisateur", "Liza", "Beaudoin", LocalDate.of(1983, Month.JUNE, 13), "utlisateur@gmail.com", "Utilisateur@", false, null);
            User userAdmin = new User("admin", "Alexis", "Clavette", LocalDate.of(1950, Month.SEPTEMBER, 29), "admin@gmail.com", "Administrateur@", true, null);
            userRepository.save(user);
            userRepository.save(userAdmin);
        };
    }
}
