package com.ourowproject.owproject.repositories;

import com.ourowproject.owproject.entities.Match;
import com.ourowproject.owproject.utilities.Status;
import org.springframework.data.repository.CrudRepository;

public interface MatchRepository extends CrudRepository<Match, Long>{
    Match findMatchById(Long matchId);
//    Iterable<Match> findAllByTeam1_id(Long team1_id);
//    Iterable<Match> findAllByTeam2_id(Long team2_id);
    Iterable<Match> findAllByDate(String date);
    Iterable<Match> findAllByStatus(Status status);
}
