package com.ourowproject.owproject.dtos;

import java.util.List;

public class PandaMatch {
    public int id;
    public String name;
    public String begin_at;
    public List<Opponent> opponents;
    public List<Result> results;

    public PandaMatch(int id, String name, String begin_at, List<Opponent> opponents, List<Result> results) {
        this.id = id;
        this.name = name;
        this.begin_at = begin_at;
        this.opponents = opponents;
        this.results = results;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBegin_at() {
        return begin_at;
    }

    public void setBegin_at(String begin_at) {
        this.begin_at = begin_at;
    }

    public List<Opponent> getOpponents() {
        return opponents;
    }

    public void setOpponents(List<Opponent> opponents) {
        this.opponents = opponents;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
