package com.ourowproject.owproject.repositories;

import com.ourowproject.owproject.entities.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Long>{
    Player findPlayerByplayerID(Long playerId);
    Iterable<Player> findAllPlayersByteamID(Long teamId);
}
