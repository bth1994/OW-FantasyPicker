package com.ourowproject.owproject.services;

import com.ourowproject.owproject.entities.Player;
import com.ourowproject.owproject.repositories.PlayerRepository;
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

public class PlayerServiceTest {

    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private PlayerService playerService;

    private Player testPlayer;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        testPlayer = new Player();
        testPlayer.setId(1L);
        testPlayer.setTeam_id(5L);
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
        when(playerRepository.findPlayerById(1L)).thenReturn(testPlayer);

        ResponseEntity<Player> expected = new ResponseEntity<>(testPlayer, OK);
        ResponseEntity<Player> actual = playerService.getPlayerById(testPlayer.getId());

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllPlayersByTeamIdTest() {

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
