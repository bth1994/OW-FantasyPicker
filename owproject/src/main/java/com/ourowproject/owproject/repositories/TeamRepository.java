package com.ourowproject.owproject.repositories;

import com.ourowproject.owproject.entities.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Long>{
    Team findTeamById(Long teamId);

}
