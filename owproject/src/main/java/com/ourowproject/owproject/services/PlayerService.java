package com.ourowproject.owproject.services;

import com.ourowproject.owproject.entities.Player;
import com.ourowproject.owproject.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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

    @Cacheable("allPlayersCache")
    @CacheEvict(value = "playerCache", allEntries = true)
    public ResponseEntity<Iterable<Player>> getAllPlayers() {
        return new ResponseEntity<>(playerRepository.findAll(), HttpStatus.OK);
    }

    @Cacheable("playerCache")
    public ResponseEntity<Player> getPlayerById(Long playerId) {
        return new ResponseEntity<>(playerRepository.findPlayerById(playerId), HttpStatus.OK);
    }
    @Cacheable("playerCache")
    public ResponseEntity<Iterable<Player>> getAllPlayersByTeamId(Long teamId) {
        return new ResponseEntity<>(playerRepository.findAllPlayersByTeamId(teamId), HttpStatus.OK);
    }

    @CachePut("playerCache")
    public ResponseEntity<Player> createPlayer(Player player) {
        return new ResponseEntity<>(playerRepository.save(player), HttpStatus.CREATED);
    }

    @CachePut("playerCache")
    public ResponseEntity<Player> updatePlayer(Player player) {
        return new ResponseEntity<>(playerRepository.save(player), HttpStatus.OK);
    }

}
