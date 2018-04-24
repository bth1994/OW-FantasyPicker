package com.ourowproject.owproject.controllers;

import com.ourowproject.owproject.entities.Player;
import com.ourowproject.owproject.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlayerController {

    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }

    @RequestMapping(value = "/players", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Player>> getAllPlayers(){
        return playerService.getAllPlayers();
    }

    @RequestMapping(value = "/players/{playerId}", method = RequestMethod.GET)
    public ResponseEntity<Player> getPlayerByplayerID(@PathVariable Long playerId){
        return playerService.getPlayerByplayerID(playerId);
    }

    @RequestMapping(value = "/players/{teamId}/team", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Player>> findAllPlayersByteamID(@PathVariable Long teamId){
        return playerService.findAllPlayersByteamID(teamId);
    }

    @RequestMapping(value = "/players", method = RequestMethod.POST)
    public ResponseEntity<Player> createPlayer(@RequestBody Player player){
        return playerService.createPlayer(player);
    }

    @RequestMapping(value = "/players", method = RequestMethod.PUT)
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player){
        return playerService.updatePlayer(player);
    }

}
