package com.ourowproject.owproject.controllers;

import com.ourowproject.owproject.entities.User;
import com.ourowproject.owproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<Iterable<User>> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @RequestMapping(value = "/users/{userId}/streak", method = RequestMethod.GET)
    public ResponseEntity<Long> getCurrentStreakByUserId(@PathVariable Long userId) {
        return userService.getCurrentStreakByUserId(userId);
    }

    @RequestMapping(value = "/users/{userId}/best", method = RequestMethod.GET)
    public ResponseEntity<Long> getBestStreakByUserId(@PathVariable Long userId) {
        return userService.getBestStreakByUserId(userId);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<User> createUser(User user) {
        return userService.createUser(user);
    }

    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(User user) {
        return userService.updateUser(user);
    }

}
