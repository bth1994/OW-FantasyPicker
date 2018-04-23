package com.ourowproject.owproject.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

    @Column(name = "PROFILE_ID")
    private Long profile_id;

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

    public Long getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(Long profile_id) {
        this.profile_id = profile_id;
    }
}
