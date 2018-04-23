package com.ourowproject.owproject.controllers;

import com.ourowproject.owproject.entities.Match;
import com.ourowproject.owproject.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatchController {

    private MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService){
        this.matchService = matchService;
    }

    @RequestMapping(value = "/matches/{matchId}", method = RequestMethod.GET)
    public ResponseEntity<Match> getMatchById(@PathVariable Long matchId){
        return matchService.getMatchById(matchId);
    }
}
