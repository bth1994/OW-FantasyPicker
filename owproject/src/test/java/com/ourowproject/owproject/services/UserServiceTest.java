package com.ourowproject.owproject.services;

import com.ourowproject.owproject.entities.User;
import com.ourowproject.owproject.repositories.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User testUser;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        testUser = new User();
        testUser.setId(1L);
        testUser.setBestStreak(2L);
        testUser.setCurrentStreak(1L);
    }

    @Test
    public void getAllUsersTest() {
        Iterable<User> userList = new ArrayList<>();
        given(userRepository.findAll()).willReturn(userList);

        ResponseEntity<Iterable<User>> expected = new ResponseEntity<>(userList, OK);
        ResponseEntity<Iterable<User>> actual = userService.getAllUsers();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getUserByIdTest() {
        when(userRepository.findUserById(1L)).thenReturn(testUser);

        ResponseEntity<User> expected = new ResponseEntity<>(testUser, OK);
        ResponseEntity<User> actual = userService.getUserById(testUser.getId());

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCurrentStreakByUserIdTest() {
        when(userRepository.findUserById(isA(Long.class))).thenReturn(testUser);

        ResponseEntity<Long> expected = new ResponseEntity<>(testUser.getCurrentStreak(), OK);
        ResponseEntity<Long> actual = userService.getCurrentStreakByUserId(testUser.getId());

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getBestStreakByUserIdTest() {
        when(userRepository.findUserById(isA(Long.class))).thenReturn(testUser);

        ResponseEntity<Long> expected = new ResponseEntity<>(testUser.getBestStreak(), OK);
        ResponseEntity<Long> actual = userService.getBestStreakByUserId(testUser.getId());

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void createUserTest() {
        User testUser2 = new User();
        testUser2.setId(2L);
        when(userRepository.save(isA(User.class))).thenReturn(testUser2);

        ResponseEntity<User> expected = new ResponseEntity<>(testUser2, CREATED);
        ResponseEntity<User> actual = userService.createUser(testUser2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void updateUserTest() {
        when(userRepository.save(isA(User.class))).thenReturn(testUser);

        ResponseEntity<User> expected = new ResponseEntity<>(testUser, OK);
        ResponseEntity<User> actual = userService.updateUser(testUser);

        Assert.assertEquals(expected, actual);
    }

}
