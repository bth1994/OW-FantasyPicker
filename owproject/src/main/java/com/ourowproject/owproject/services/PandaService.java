package com.ourowproject.owproject.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ourowproject.owproject.dtos.PandaMatch;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class PandaService {


    public ResponseEntity<PandaMatch[]> getUpcomingMatches() {
        RestTemplate restTemplate = new RestTemplate();
        String uri = "https://api.pandascore.co/ow/matches/upcoming?token=KkzVUEMJ_pTaGQvbtRQo7YQewGzIauH1XqUEWwuRC-KQVQWg8U0";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
        System.out.println(responseEntity.getBody());
        ObjectMapper objectMapper = new ObjectMapper();
        PandaMatch[] pandaMatches = null;
        try {
            pandaMatches = objectMapper.readValue(responseEntity.getBody(), PandaMatch[].class);
        } catch (Exception e){
            System.out.println(e);
        }
        return new ResponseEntity<>(pandaMatches, HttpStatus.OK);
    }

    public ResponseEntity<PandaMatch> getTestMatch() {
        RestTemplate restTemplate = new RestTemplate();
        String uri = "https://api.pandascore.co/ow/matches/20502?token=KkzVUEMJ_pTaGQvbtRQo7YQewGzIauH1XqUEWwuRC-KQVQWg8U0";
        PandaMatch result = restTemplate.getForObject(uri, PandaMatch.class);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
