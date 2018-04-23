package com.ourowproject.owproject.services;

import com.ourowproject.owproject.entities.Team;
import com.ourowproject.owproject.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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

    @Cacheable("allTeamCache")
    @CacheEvict(value = "teamCache", allEntries = true)
    public ResponseEntity<Iterable<Team>> getAllTeams() {
        return new ResponseEntity<>(teamRepository.findAll(), HttpStatus.OK);
    }
    @Cacheable("teamCache")
    public ResponseEntity<Team> getTeamById(Long teamId) {
        return new ResponseEntity<>(teamRepository.findTeamById(teamId), HttpStatus.OK);
    }

    @CachePut("teamCache")
    public ResponseEntity<Team> createTeam(Team team) {
        return new ResponseEntity<>(teamRepository.save(team), HttpStatus.CREATED);
    }

    @CachePut("teamCache")
    public ResponseEntity<Team> updateTeam(Team team) {
        return new ResponseEntity<>(teamRepository.save(team), HttpStatus.OK);
    }
}
