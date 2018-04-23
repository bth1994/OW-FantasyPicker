package com.ourowproject.owproject.dtos;

import java.util.List;

public class PandaMatch {
    public int id;
    public String name;
    public String begin_at;
    public List<Opponent> opponents;
    public List<Result> results;
}
