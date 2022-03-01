package com.bezkoder.spring.jwt.mongodb.security.services;

import com.bezkoder.spring.jwt.mongodb.models.ERole;
import com.bezkoder.spring.jwt.mongodb.models.Role;
import com.bezkoder.spring.jwt.mongodb.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {


    /*get all users*/
    List<User> getAllUser();

    /*get user by username*/
    Optional<User> getUserByUsername (String username);

    /*delete user by username*/
    //void deleteUserByUsername(String username) ;

    /*delete user by id*/
    void deleteUserById(String id);

    /*get user by id*/
    Optional<User> getUserById (String id);

    /*get user by role*/
    List<User> getUsersByRole (String id);



}
