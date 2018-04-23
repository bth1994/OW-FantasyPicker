package com.ourowproject.owproject.services;

import com.ourowproject.owproject.entities.Choice;
import com.ourowproject.owproject.entities.User;
import com.ourowproject.owproject.repositories.ChoiceRepository;
import com.ourowproject.owproject.repositories.MatchRepository;
import com.ourowproject.owproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ChoiceService {

    private ChoiceRepository choiceRepository;
    private MatchRepository matchRepository;
    private UserRepository userRepository;

    @Autowired
    public ChoiceService(ChoiceRepository choiceRepository, MatchRepository matchRepository, UserRepository userRepository) {
        this.choiceRepository = choiceRepository;
        this.matchRepository = matchRepository;
        this.userRepository = userRepository;
    }

    @Cacheable("allChoiceCache")
    @CacheEvict(value = "choiceCache", allEntries = true)
    public ResponseEntity<Iterable<Choice>> getAllChoices() {
        return new ResponseEntity<>(choiceRepository.findAll(), HttpStatus.OK);
    }

//    public ResponseEntity<Iterable<Choice>> getAllChoicesByMatch_id(Long match_id) {
//        return new ResponseEntity<>(choiceRepository.getAllChoicesByMatch_id(match_id), HttpStatus.OK);
//    }

//    public ResponseEntity<Iterable<Choice>> getAllChoicesByUser_id(Long userId) {
//        return new
//    }

    @Cacheable("choiceCache")
    public ResponseEntity<Choice> getChoiceById(Long choiceId) {
        return new ResponseEntity<>(choiceRepository.findChoiceById(choiceId), HttpStatus.OK);
    }

    @CachePut("choiceCache")
    public ResponseEntity<Choice> createChoice(Choice choice) {
        return new ResponseEntity<>(choiceRepository.save(choice), HttpStatus.CREATED);
    }

    @CachePut("choiceCache")
    public ResponseEntity<Choice> updateChoice(Choice choice) {
        return new ResponseEntity<>(choiceRepository.save(choice), HttpStatus.OK);
    }
}
