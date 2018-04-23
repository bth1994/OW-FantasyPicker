package com.ourowproject.owproject.services;

import com.ourowproject.owproject.entities.Team;
import com.ourowproject.owproject.repositories.TeamRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

public class TeamServiceTest {

    @Mock
    private TeamRepository teamRepository;

    @InjectMocks
    private TeamService teamService;

    private Team testTeam;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        testTeam = new Team();
        testTeam.setId(1L);
    }

    @Test
    public void getAllTeamsTest() {
        Iterable<Team> teamList = new ArrayList<>();
        given(teamRepository.findAll()).willReturn(teamList);

        ResponseEntity<Iterable<Team>> expected = new ResponseEntity<>(teamList, OK);
        ResponseEntity<Iterable<Team>> actual = teamService.getAllTeams();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTeamByIdTest() {
        when(teamRepository.findTeamById(1L)).thenReturn(testTeam);

        ResponseEntity<Team> expected = new ResponseEntity<>(testTeam, OK);
        ResponseEntity<Team> actual = teamService.getTeamById(testTeam.getId());

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void createTeamTest() {
        when(teamRepository.save(isA(Team.class))).thenReturn(testTeam);

        ResponseEntity<Team> expected = new ResponseEntity<>(testTeam, CREATED);
        ResponseEntity<Team> actual = teamService.createTeam(testTeam);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void updateUserTest() {
        when(teamRepository.save(isA(Team.class))).thenReturn(testTeam);

        ResponseEntity<Team> expected = new ResponseEntity<>(testTeam, OK);
        ResponseEntity<Team> actual = teamService.updateTeam(testTeam);

        Assert.assertEquals(expected, actual);
    }
}
