package com.ourowproject.owproject.repositories;

import com.ourowproject.owproject.entities.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Long>{
    Player findPlayerById(Long playerId);
    Iterable<Player> findAllPlayersByteam_id(Long teamId);
}
