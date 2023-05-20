package com.project.happy_fly.repository;

import com.project.happy_fly.model.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<City, String> {
}
