package com.ourowproject.owproject.repositories;

import com.ourowproject.owproject.entities.Match;
import com.ourowproject.owproject.utilities.Status;
import org.springframework.data.repository.CrudRepository;

public interface MatchRepository extends CrudRepository<Match, Long>{
    Match findMatchBymatchID(Long matchId);
    Iterable<Match> findAllByteam1ID(Long team1_id);
    Iterable<Match> findAllByteam2ID(Long team2_id);
    Iterable<Match> findAllByDate(String date);
    Iterable<Match> findAllByStatus(Status status);
}
