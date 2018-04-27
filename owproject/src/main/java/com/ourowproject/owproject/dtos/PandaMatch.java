package com.ourowproject.owproject.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
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
    public int opponent1;
    public int opponent2;

    public PandaMatch(int id, String date, int opponent1, int opponent2) {
        this.id = id;
        this.date = date;
        this.opponent1 = opponent1;
        this.opponent2 = opponent2;
    }

    public PandaMatch(){
        this.id = 0;
        this.date = "";
        this.opponent1 = 0;
        this.opponent2 = 0;
    }

    public PandaMatch(String result) throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        int id = objectMapper.readTree(result).get("id").asInt();
        String date = objectMapper.readTree(result).get("begin_at").asText();
        JsonNode opponents = objectMapper.readTree(result).get("opponents");
        ArrayList<Integer> opids = new ArrayList<>();
        if (opponents.isArray()) {
            for (JsonNode jsonNode : opponents) {
                opids.add(jsonNode.get("id").asInt());
            }
        }
        this.id = id;
        this.date = date;
        this.opponent1 = opids.get(0);
        this.opponent2 = opids.get(1);
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
