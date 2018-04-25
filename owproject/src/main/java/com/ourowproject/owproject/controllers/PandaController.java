package com.ourowproject.owproject.controllers;

import com.ourowproject.owproject.dtos.PandaMatch;
import com.ourowproject.owproject.services.PandaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PandaController {

    private PandaService pandaService;

    @Autowired
    public PandaController(PandaService pandaService){
        this.pandaService = pandaService;
    }

    @RequestMapping(value = "/panda/upcomingmatches", method = RequestMethod.GET)
    public ResponseEntity<Iterable<PandaMatch>> getUpcomingMatches(){
        return pandaService.getUpcomingMatches();
    }

    @RequestMapping(value = "/panda/test", method = RequestMethod.GET)
    public ResponseEntity<PandaMatch> getTestMatch(){
        return pandaService.getTestMatch();
    }
}
