package com.ourowproject.owproject.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@JsonIgnoreProperties(ignoreUnknown=true)
public class PandaMatch {

    @JsonProperty("id") public int id;
    @JsonProperty("begin_at") public String date;
    @JsonProperty("opponents") public Iterable teams;
    public int opponent1;
    public int opponent2;

    @JsonCreator
    public PandaMatch(@JsonProperty("id") int id, @JsonProperty("begin_at") String date, @JsonProperty("opponents") Iterable teams){
        this.id = id;
        this.date = date;
        this.teams = teams;
        Iterator iterator = teams.iterator();
        Object temp = iterator.next();
        String tempString = temp.toString();
        Pattern pattern = Pattern.compile("id=(\\d\\d\\d\\d)");
        Matcher matcher = pattern.matcher(tempString);
        System.out.println(matcher.find());
        System.out.println(matcher.group().substring(3));
        opponent1 = Integer.parseInt(matcher.group().substring(3));
        Object temp2 = iterator.next();
        String tempString2 = temp2.toString();
        Pattern pattern2 = Pattern.compile("id=(\\d\\d\\d\\d)");
        Matcher matcher2 = pattern2.matcher(tempString2);
        System.out.println(matcher2.find());
        System.out.println(matcher2.group().substring(3));
        opponent2 = Integer.parseInt(matcher2.group().substring(3));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Iterable getTeams() {
        return teams;
    }

    public void setTeams(Iterable teams) {
        this.teams = teams;
    }

    public int getOpponent1() {
        return opponent1;
    }

    public void setOpponent1(int opponent1) {
        this.opponent1 = opponent1;
    }

    public int getOpponent2() {
        return opponent2;
    }

    public void setOpponent2(int opponent2) {
        this.opponent2 = opponent2;
    }
}
