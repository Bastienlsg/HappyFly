package com.project.happy_fly.configuration;

import com.project.happy_fly.repository.UserRepository;
import com.project.happy_fly.repository.CountryRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

public class DatabaseData {
    private final UserRepository userRepository;
    private final CountryRepository countryRepository;


    public DatabaseData(UserRepository userRepository, CountryRepository countryRepository) {
        this.userRepository = userRepository;
        this.countryRepository = countryRepository;
    }

    @Bean
    public CommandLineRunner initData() {
        return args -> {
            UserInitializer userInitializer = new UserInitializer(this.userRepository);
            userInitializer.initializeUsers();

            CityCountryInitializer countriesCitiesInitializer = new CityCountryInitializer(this.countryRepository);
            countriesCitiesInitializer.initializeCountriesCities();
        };
    }
}
