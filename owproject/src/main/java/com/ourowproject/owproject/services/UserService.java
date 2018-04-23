package com.ourowproject.owproject.services;

//import com.amazonaws.services.rds.model.ResourceNotFoundException;
import com.ourowproject.owproject.entities.User;
import com.ourowproject.owproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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

    @Cacheable("allUserCache")
    @CacheEvict(value = "userCache", allEntries = true)
    public ResponseEntity<Iterable<User>> getAllUsers() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @Cacheable("userCache")
    public ResponseEntity<User> getUserById(Long userId) {
        return new ResponseEntity<>(userRepository.findUserById(userId), HttpStatus.OK);
    }

    @Cacheable("userCache")
    public ResponseEntity<Long> getCurrentStreakByUserId(Long userId) {
        return new ResponseEntity<>(userRepository.findUserById(userId).getCurrentStreak(), HttpStatus.OK);
    }

    @Cacheable("userCache")
    public ResponseEntity<Long> getBestStreakByUserId(Long userId) {
        return new ResponseEntity<>(userRepository.findUserById(userId).getBestStreak(), HttpStatus.OK);
    }

    @CachePut("userCache")
    public ResponseEntity<User> createUser(User user) {
        user = userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @CachePut("userCache")
    public ResponseEntity<User> updateUser(User user) {
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.OK);
    }

}
