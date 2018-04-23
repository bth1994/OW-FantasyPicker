package com.ourowproject.owproject.entities;

import com.ourowproject.owproject.utilities.Status;

import javax.persistence.*;

@Entity
public class Match {

    @Id
    @GeneratedValue
    @Column(name = "MATCH_ID")
    private Long id;

    @Column(name = "TEAM1_ID")
    private Long team1_id;

    @Column(name = "TEAM2_ID")
    private Long team2_id;

    @Column(name = "WINNER_ID")
    private Long winner_id;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "STATUS")
    private Status status;

    @Column(name = "DATE")
    private String date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeam1_id() {
        return team1_id;
    }

    public void setTeam1_id(Long team1_id) {
        this.team1_id = team1_id;
    }

    public Long getTeam2_id() {
        return team2_id;
    }

    public void setTeam2_id(Long team2_id) {
        this.team2_id = team2_id;
    }

    public Long getWinner_id() {
        return winner_id;
    }

    public void setWinner_id(Long winner_id) {
        this.winner_id = winner_id;
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
