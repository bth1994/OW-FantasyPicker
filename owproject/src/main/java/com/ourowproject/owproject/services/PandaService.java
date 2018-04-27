package com.ourowproject.owproject.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.ourowproject.owproject.dtos.PandaMatch;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

@Service
public class PandaService {


    //Can't get list of upcoming games, /fliptable
    public ResponseEntity<Iterable<PandaMatch>> getUpcomingMatches() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        String uri = "https://api.pandascore.co/ow/matches/upcoming?token=KkzVUEMJ_pTaGQvbtRQo7YQewGzIauH1XqUEWwuRC-KQVQWg8U0";
        String result = restTemplate.getForObject(uri, String.class);
//        String[] strings = result.split("\"games\":\\[");
//        ArrayList<PandaMatch> pandaMatches = new ArrayList<>();
//        for (String string:strings) {
//            System.out.println(string);
//            PandaMatch pandaMatch = new PandaMatch(string);
//            pandaMatches.add(pandaMatch);
//        }
        return null;
    }

    public ResponseEntity<PandaMatch> getTestMatch() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        String uri = "https://api.pandascore.co/ow/matches/20502?token=KkzVUEMJ_pTaGQvbtRQo7YQewGzIauH1XqUEWwuRC-KQVQWg8U0";
        String result = restTemplate.getForObject(uri, String.class);
        PandaMatch pandaMatch = new PandaMatch(result);
        return new ResponseEntity<>(pandaMatch, HttpStatus.OK);
    }
}
