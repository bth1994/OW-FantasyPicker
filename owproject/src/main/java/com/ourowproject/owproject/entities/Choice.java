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

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User userID;

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

    public void setMatch_id(Long match_id) {
        this.matchID = match_id;
    }

    public User getProfile_id() {
        return userID;
    }

    public void setProfile_id(User userID) {
        this.userID = userID;
    }
}
