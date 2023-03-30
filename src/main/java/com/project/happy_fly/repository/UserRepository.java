package com.project.happy_fly.repository;

import org.springframework.data.repository.CrudRepository;
import com.project.happy_fly.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
}
