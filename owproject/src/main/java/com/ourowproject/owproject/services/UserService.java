package com.ourowproject.owproject.services;

import com.amazonaws.services.rds.model.ResourceNotFoundException;
import com.ourowproject.owproject.entities.User;
import com.ourowproject.owproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<Iterable<User>> getAllUsers() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<User> getUserById(Long userId) {
        return new ResponseEntity<>(userRepository.findUserById(userId), HttpStatus.OK);
    }

    public ResponseEntity<Long> getStreakByUser(Long userId) {
        return new ResponseEntity<>(userRepository.findUserById(userId).getCurrentStreak(), HttpStatus.OK);
    }

    public ResponseEntity<Long> getBestStreakByUser(Long userId) {
        return new ResponseEntity<>(userRepository.findUserById(userId).getBestStreak(), HttpStatus.OK);
    }

    public ResponseEntity<User> createUser(User user) {
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
    }

    public ResponseEntity<User> updateUser(User user) {
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.OK);
    }

}
