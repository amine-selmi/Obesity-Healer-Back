package com.bezkoder.spring.jwt.mongodb.repository;

import java.util.List;
import java.util.Optional;

import com.bezkoder.spring.jwt.mongodb.models.ERole;
import com.bezkoder.spring.jwt.mongodb.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.bezkoder.spring.jwt.mongodb.models.User;

public interface UserRepository extends MongoRepository<User, String> {
  Optional<User> findByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);

  List<User> findAllByRolesId (String id);


}
