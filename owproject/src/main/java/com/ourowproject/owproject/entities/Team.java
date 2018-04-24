package com.ourowproject.owproject.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Team {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "TEAM_ID")
    private Long teamID;

    @Column(name = "TEAM_NAME")
    private String name;

    @Column(name = "WIN_RECORD")
    private Long winRecord;

    @Column(name = "LOSS_RECORD")
    private Long lossRecord;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeamID() {
        return teamID;
    }

    public void setTeamID(Long teamID) {
        this.teamID = teamID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getWinRecord() {
        return winRecord;
    }

    public void setWinRecord(Long winRecord) {
        this.winRecord = winRecord;
    }

    public Long getLossRecord() {
        return lossRecord;
    }

    public void setLossRecord(Long lossRecord) {
        this.lossRecord = lossRecord;
    }
}
