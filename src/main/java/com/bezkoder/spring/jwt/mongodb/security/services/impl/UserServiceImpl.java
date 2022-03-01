package com.bezkoder.spring.jwt.mongodb.security.services.impl;

import com.bezkoder.spring.jwt.mongodb.models.ERole;
import com.bezkoder.spring.jwt.mongodb.models.Role;
import com.bezkoder.spring.jwt.mongodb.models.User;
import com.bezkoder.spring.jwt.mongodb.repository.UserRepository;
import com.bezkoder.spring.jwt.mongodb.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        Optional<User> user ;
        user = userRepository.findByUsername(username);
        return user;
    }

    @Override
    public void deleteUserById(String id) {
        userRepository.deleteById(id);

    }

//    @Override
//    public void deleteUserByUsername(String id) {
//
//        userRepository.delete(getUserById(id).get());
//    }

    @Override
    public Optional<User> getUserById(String id) {
        Optional<User> user ;
        user = userRepository.findById(id);
        return user;
    }

    @Override
    public List<User> getUsersByRole(String id) {
        return userRepository.findAllByRolesId(id);
    }


}
