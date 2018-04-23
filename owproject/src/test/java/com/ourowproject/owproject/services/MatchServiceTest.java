package com.ourowproject.owproject.services;

import com.ourowproject.owproject.entities.Match;
import com.ourowproject.owproject.repositories.MatchRepository;
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

public class MatchServiceTest {

    @Mock
    private MatchRepository matchRepository;

    @InjectMocks
    private MatchService matchService;

    private Match testMatch;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        testMatch = new Match();
        testMatch.setId(1L);
    }

    @Test
    public void getAllMatchesTest() {
        Iterable<Match> matchList = new ArrayList<>();
        given(matchRepository.findAll()).willReturn(matchList);

        ResponseEntity<Iterable<Match>> expected = new ResponseEntity<>(matchList, OK);
        ResponseEntity<Iterable<Match>> actual = matchService.getAllMatches();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getMatchByIdTest() {
        when(matchRepository.findMatchById(1L)).thenReturn(testMatch);

        ResponseEntity<Match> expected = new ResponseEntity<>(testMatch, OK);
        ResponseEntity<Match> actual = matchService.getMatchById(testMatch.getId());

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void createMatchTest() {
        when(matchRepository.save(isA(Match.class))).thenReturn(testMatch);

        ResponseEntity<Match> expected = new ResponseEntity<>(testMatch, CREATED);
        ResponseEntity<Match> actual = matchService.createMatch(testMatch);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void updateMatchTest() {
        when(matchRepository.save(isA(Match.class))).thenReturn(testMatch);

        ResponseEntity<Match> expected = new ResponseEntity<>(testMatch, OK);
        ResponseEntity<Match> actual = matchService.updateMatch(testMatch);

        Assert.assertEquals(expected, actual);
    }
}
