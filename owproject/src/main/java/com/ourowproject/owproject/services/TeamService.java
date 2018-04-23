package com.ourowproject.owproject.services;

import com.ourowproject.owproject.entities.Team;
import com.ourowproject.owproject.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    private TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public ResponseEntity<Iterable<Team>> getAllTeams() {
        return new ResponseEntity<>(teamRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Team> getTeamById(Long teamId) {
        return new ResponseEntity<>(teamRepository.findTeamById(teamId), HttpStatus.OK);
    }

    public ResponseEntity<Team> createTeam(Team team) {
        return new ResponseEntity<>(teamRepository.save(team), HttpStatus.CREATED);
    }

    public ResponseEntity<Team> updateTeam(Team team) {
        return new ResponseEntity<>(teamRepository.save(team), HttpStatus.OK);
    }
}
