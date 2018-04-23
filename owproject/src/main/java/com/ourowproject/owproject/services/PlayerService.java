package com.ourowproject.owproject.services;

import com.ourowproject.owproject.entities.Player;
import com.ourowproject.owproject.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    private PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public ResponseEntity<Iterable<Player>> getAllPlayers() {
        return new ResponseEntity<>(playerRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Player> getPlayerById(Long playerId) {
        return new ResponseEntity<>(playerRepository.findPlayerById(playerId), HttpStatus.OK);
    }

    public ResponseEntity<Iterable<Player>> getAllPlayersByTeamId(Long teamId) {
        return new ResponseEntity<>(playerRepository.findAllPlayersByTeamId(teamId), HttpStatus.OK);
    }

    //public ResponseEntity<Player>
}
