package com.ourowproject.owproject.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Player {

    @Id
    @GeneratedValue
    @Column(name = "PLAYER_ID")
    private Long id;

    @Column(name = "TEAM_ID")
    private Long team_id;
}
