package com.project.happy_fly.configuration;

import com.project.happy_fly.model.City;
import com.project.happy_fly.model.Country;
import com.project.happy_fly.repository.CountryRepository;

import java.util.HashSet;
import java.util.Set;

public class CityCountryInitializer {
    private final CountryRepository countryRepository;

    public CityCountryInitializer(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public void initializeCountriesCities() {
        Country france = new Country("France", null);
        Country usa = new Country("USA", null);

        City rennes = new City(0, "Rennes", france);
        City angers = new City(0, "Angers", france);
        City newYork = new City(0, "New York", usa);
        City losAngeles = new City(0, "Los Angeles", usa);

        Set<City> franceCities = new HashSet<>();
        franceCities.add(rennes);
        franceCities.add(angers);
        france.setCities(franceCities);

        Set<City> usaCities = new HashSet<>();
        usaCities.add(newYork);
        usaCities.add(losAngeles);
        usa.setCities(usaCities);

        this.countryRepository.save(france);
        this.countryRepository.save(usa);
    }
}
