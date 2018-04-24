package com.ourowproject.owproject.entities;

import javax.persistence.*;

@Entity
public class Choice {

    @Id
    @GeneratedValue
    @Column(name = "CHOICE_ID")
    private Long id;


    @Column(name = "SELECTION")
    private Long selection;

    @Column(name = "MATCH_ID")
    private Long matchID;

    @Column(name = "USER_ID")
    private Long userID;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSelection() {
        return selection;
    }

    public void setSelection(Long selection) {
        this.selection = selection;
    }

    public Long getMatchID() {
        return matchID;
    }

    public void setMatchID(Long matchID) {
        this.matchID = matchID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }
}
