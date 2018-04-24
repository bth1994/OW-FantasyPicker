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

    @Autowired
    public ChoiceService(ChoiceRepository choiceRepository) {
        this.choiceRepository = choiceRepository;
    }

    @Cacheable("allChoiceCache")
    @CacheEvict(value = "choiceCache", allEntries = true)
    public ResponseEntity<Iterable<Choice>> getAllChoices() {
        return new ResponseEntity<>(choiceRepository.findAll(), HttpStatus.OK);
    }

    @Cacheable("allChoiceCache")
    @CacheEvict(value = "choiceCache", allEntries = true)
    public ResponseEntity<Iterable<Choice>> getAllChoicesBymatch_id(Long match_id) {
        return new ResponseEntity<>(choiceRepository.getAllChoicesBymatch_id(match_id), HttpStatus.OK);
    }

    @Cacheable("allChoiceCache")
    @CacheEvict(value = "choiceCache", allEntries = true)
    public ResponseEntity<Iterable<Choice>> getAllChoicesByprofile_id(Long userId) {
        return new ResponseEntity<>(choiceRepository.getAllChoicesByuser_id(userId), HttpStatus.OK);
    }

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
