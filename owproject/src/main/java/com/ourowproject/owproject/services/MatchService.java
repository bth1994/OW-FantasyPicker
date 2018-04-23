package com.ourowproject.owproject.services;

import com.ourowproject.owproject.entities.Match;
import com.ourowproject.owproject.repositories.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public ResponseEntity<Iterable<Match>> getAllMatches() {
        return new ResponseEntity<>(matchRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Match> getMatchById(Long matchId) {
        return new ResponseEntity<>(matchRepository.findMatchById(matchId), HttpStatus.OK);
    }

    public ResponseEntity<Match> createMatch(Match match) {
        return new ResponseEntity<>(matchRepository.save(match), HttpStatus.CREATED);
    }

    public ResponseEntity<Match> updateMatch(Match match) {
        return new ResponseEntity<>(matchRepository.save(match), HttpStatus.OK);
    }
}
