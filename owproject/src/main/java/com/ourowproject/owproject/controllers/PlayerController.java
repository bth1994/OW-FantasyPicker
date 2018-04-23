package com.ourowproject.owproject.controllers;

import com.ourowproject.owproject.entities.Player;
import com.ourowproject.owproject.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Player> getPlayerById(@PathVariable Long playerId){
        return playerService.getPlayerById(playerId);
    }

    @RequestMapping(value = "/players/{teamId}/team", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Player>> getAllPlayersByTeamId(@PathVariable Long teamId){
        return playerService.getAllPlayersByTeamId(teamId);
    }

    @RequestMapping(value = "/players", method = RequestMethod.POST)
    public ResponseEntity<Player> createPlayer(Player player){
        return playerService.createPlayer(player);
    }

    @RequestMapping(value = "/players", method = RequestMethod.PUT)
    public ResponseEntity<Player> updatePlayer(Player player){
        return playerService.updatePlayer(player);
    }

}
