package com.ourowproject.owproject.controllers;

import com.ourowproject.owproject.entities.Match;
import com.ourowproject.owproject.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MatchController {

    private MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService){
        this.matchService = matchService;
    }

    @RequestMapping(value = "/matches", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Match>> getAllMatches(){
        return matchService.getAllMatches();
    }

    @RequestMapping(value = "/matches/{matchId}", method = RequestMethod.GET)
    public ResponseEntity<Match> getMatchById(@PathVariable Long matchId){
        return matchService.getMatchById(matchId);
    }

    @RequestMapping(value = "/matches", method = RequestMethod.POST)
    public ResponseEntity<Match> createMatch(@RequestBody Match match){
        return matchService.createMatch(match);
    }

    @RequestMapping(value = "/matches", method = RequestMethod.PUT)
    public ResponseEntity<Match> updateMatch(@RequestBody Match match){
        return matchService.updateMatch(match);
    }
}
