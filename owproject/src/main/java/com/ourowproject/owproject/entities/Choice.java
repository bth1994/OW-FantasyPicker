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
    private Long match_id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

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

    public Long getMatch_id() {
        return match_id;
    }

    public void setMatch_id(Long match_id) {
        this.match_id = match_id;
    }

    public User getProfile_id() {
        return user;
    }

    public void setProfile_id(User profile_id) {
        this.user = profile_id;
    }
}
