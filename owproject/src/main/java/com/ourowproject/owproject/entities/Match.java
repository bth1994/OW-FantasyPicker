package com.ourowproject.owproject.entities;

import com.ourowproject.owproject.utilities.Status;

import javax.persistence.*;

@Entity
@Table(name = "owlmatch")
public class Match {

    @Id
    @Column(name = "MATCH_ID")
    private Long matchID;

    @Column(name = "TEAM1_ID")
    private Long team1ID;

    @Column(name = "TEAM2_ID")
    private Long team2ID;

    @Column(name = "WINNER_ID")
    private Long winnerID;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "STATUS")
    private Status status;

    @Column(name = "DATE")
    private String date;

    public Long getMatchID() {
        return matchID;
    }

    public void setMatchID(Long id) {
        this.matchID = id;
    }

    public Long getTeam1_id() {
        return team1ID;
    }

    public void setTeam1_id(Long team1_id) {
        this.team1ID = team1_id;
    }

    public Long getTeam2_id() {
        return team2ID;
    }

    public void setTeam2_id(Long team2_id) {
        this.team2ID = team2_id;
    }

    public Long getWinner_id() {
        return winnerID;
    }

    public void setWinner_id(Long winner_id) {
        this.winnerID = winner_id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
