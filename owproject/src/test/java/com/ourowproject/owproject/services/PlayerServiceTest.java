package com.ourowproject.owproject.services;

import com.ourowproject.owproject.entities.Match;
import com.ourowproject.owproject.entities.Player;
import com.ourowproject.owproject.entities.Team;
import com.ourowproject.owproject.repositories.PlayerRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static java.util.Collections.singletonList;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

public class PlayerServiceTest {

    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private PlayerService playerService;

    private Player testPlayer;
    private Team testTeam;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        testPlayer = new Player();
        testPlayer.setId(1L);
        testPlayer.setTeamID(5L);

        testTeam = new Team();
        testTeam.setId(2L);
    }

    @Test
    public void getAllPlayersTest() {
        Iterable<Player> playerList = new ArrayList<>();
        given(playerRepository.findAll()).willReturn(playerList);

        ResponseEntity<Iterable<Player>> expected = new ResponseEntity<>(playerList, OK);
        ResponseEntity<Iterable<Player>> actual = playerService.getAllPlayers();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPlayerByIdTest() {
        when(playerRepository.findPlayerByplayerID(1L)).thenReturn(testPlayer);

        ResponseEntity<Player> expected = new ResponseEntity<>(testPlayer, OK);
        ResponseEntity<Player> actual = playerService.getPlayerByplayerID(testPlayer.getId());

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllPlayersByTeamIdTest() {
        Iterable<Player> playerList = singletonList(testPlayer);
        when(playerRepository.findAllPlayersByteamID(isA(Long.class))).thenReturn(playerList);

        ResponseEntity<Iterable<Player>> expected = new ResponseEntity<>(playerList, OK);
        ResponseEntity<Iterable<Player>> actual = playerService.findAllPlayersByteamID(testTeam.getId());

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void createPlayerTest() {
        when(playerRepository.save(isA(Player.class))).thenReturn(testPlayer);

        ResponseEntity<Player> expected = new ResponseEntity<>(testPlayer, CREATED);
        ResponseEntity<Player> actual = playerService.createPlayer(testPlayer);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void updateUserTest() {
        when(playerRepository.save(isA(Player.class))).thenReturn(testPlayer);

        ResponseEntity<Player> expected = new ResponseEntity<>(testPlayer, OK);
        ResponseEntity<Player> actual = playerService.updatePlayer(testPlayer);

        Assert.assertEquals(expected, actual);
    }
}
