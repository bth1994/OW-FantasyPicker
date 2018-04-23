package com.ourowproject.owproject.entities;

import javax.persistence.*;

@Entity
public class Player {

    @Id
    @GeneratedValue
    @Column(name = "PLAYER_ID")
    private Long id;

    @Column(name = "PLAYER_NAME")
    private String name;

    @Column(name = "SLUG")
    private String slug;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Long team_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Long team_id) {
        this.team_id = team_id;
    }
}
