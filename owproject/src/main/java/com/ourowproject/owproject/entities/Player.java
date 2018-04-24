package com.ourowproject.owproject.entities;

import javax.persistence.*;

@Entity
public class Player {

    @Id
    @Column(name = "PLAYER_ID")
    private Long playerID;

    @Column(name = "PLAYER_NAME")
    private String name;

    @Column(name = "SLUG")
    private String slug;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team teamID;

    public Long getPlayerID() {
        return playerID;
    }

    public void setPlayerID(Long id) {
        this.playerID = id;
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

    public Team getTeam_id() {
        return teamID;
    }

    public void setTeam_id(Team team_id) {
        this.teamID = team_id;
    }
}
