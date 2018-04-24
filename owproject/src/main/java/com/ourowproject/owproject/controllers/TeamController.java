package com.ourowproject.owproject.controllers;

import com.ourowproject.owproject.entities.Team;
import com.ourowproject.owproject.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeamController {

    private TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService){
        this.teamService = teamService;
    }

    @RequestMapping(value = "/teams", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Team>> getAllTeams(){
        return teamService.getAllTeams();
    }

    @RequestMapping(value = "/teams/{teamId}", method = RequestMethod.GET)
    public ResponseEntity<Team> getTeamById(@PathVariable Long teamId){
        return teamService.getTeamById(teamId);
    }

    @RequestMapping(value = "/teams", method = RequestMethod.POST)
    public ResponseEntity<Team> createTeam(@RequestBody Team team){
        return teamService.createTeam(team);
    }

    @RequestMapping(value = "/teams", method = RequestMethod.PUT)
    public ResponseEntity<Team> updateTeam(@RequestBody Team team){
        return teamService.updateTeam(team);
    }

}
