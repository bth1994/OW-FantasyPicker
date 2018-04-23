package com.ourowproject.owproject.services;

import com.ourowproject.owproject.entities.User;
import com.ourowproject.owproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<Iterable<User>> getAllUsers() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

//    public ResponseEntity<Long> getStreakByUser(Long userId) {
//        return new ResponseEntity<>(userRepository.findById(userId))
//    }

}
