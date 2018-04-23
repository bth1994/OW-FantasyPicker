package com.ourowproject.owproject.dtos;

public class Result {
    public int team_id;
    public int score;

    public Result(int team_id, int score) {
        this.team_id = team_id;
        this.score = score;
    }

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
