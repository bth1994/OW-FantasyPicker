package com.ourowproject.owproject.services;

import com.ourowproject.owproject.entities.Match;
import com.ourowproject.owproject.repositories.MatchRepository;
import com.ourowproject.owproject.utilities.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MatchService {

    private MatchRepository matchRepository;

    @Autowired
    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Cacheable("allMatchesCache")
    @CacheEvict(value = "matchesCache", allEntries = true)
    public ResponseEntity<Iterable<Match>> getAllMatches() {
        return new ResponseEntity<>(matchRepository.findAll(), HttpStatus.OK);
    }

    @Cacheable("allMatchesCache")
    @CacheEvict(value = "matchesCache", allEntries = true)
    public ResponseEntity<Iterable<Match>> findAllByteam_1_id(Long team1_id) {
        return new ResponseEntity<>(matchRepository.findAllByteam1_id(team1_id), HttpStatus.OK);
    }

    @Cacheable("allMatchesCache")
    @CacheEvict(value = "matchesCache", allEntries = true)
    public ResponseEntity<Iterable<Match>> findAllByteam2_id(Long team2_id) {
        return new ResponseEntity<>(matchRepository.findAllByteam2_id(team2_id), HttpStatus.OK);
    }

    @Cacheable("allMatchesCache")
    @CacheEvict(value = "matchesCache", allEntries = true)
    public ResponseEntity<Iterable<Match>> findAllByDate(String date) {
        return new ResponseEntity<>(matchRepository.findAllByDate(date), HttpStatus.OK);
    }

    @Cacheable("allMatchesCache")
    @CacheEvict(value = "matchesCache", allEntries = true)
    public ResponseEntity<Iterable<Match>> findAllByStatus(Status status) {
        return new ResponseEntity<>(matchRepository.findAllByStatus(status), HttpStatus.OK);
    }

    @Cacheable("matchesCache")
    public ResponseEntity<Match> getMatchById(Long matchId) {
        return new ResponseEntity<>(matchRepository.findMatchById(matchId), HttpStatus.OK);
    }

    @CachePut("matchesCache")
    public ResponseEntity<Match> createMatch(Match match) {
        return new ResponseEntity<>(matchRepository.save(match), HttpStatus.CREATED);
    }

    @CachePut("matchesCache")
    public ResponseEntity<Match> updateMatch(Match match) {
        return new ResponseEntity<>(matchRepository.save(match), HttpStatus.OK);
    }

}
