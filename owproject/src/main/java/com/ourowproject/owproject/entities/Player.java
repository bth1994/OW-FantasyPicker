package com.ourowproject.owproject.entities;

import javax.persistence.*;

@Entity
public class Player {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "PLAYER_ID")
    private Long playerID;

    @Column(name = "PLAYER_NAME")
    private String name;

    @Column(name = "SLUG")
    private String slug;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team teamID;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlayerID() {
        return playerID;
    }

    public void setPlayerID(Long playerID) {
        this.playerID = playerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Team getTeamID() {
        return teamID;
    }

    public void setTeamID(Team teamID) {
        this.teamID = teamID;
    }
}
