package com.ourowproject.owproject.services;

import com.ourowproject.owproject.dtos.PandaMatch;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PandaService {


    public ResponseEntity<Iterable<PandaMatch>> getUpcomingMatches() {
        RestTemplate restTemplate = new RestTemplate();
        String uri = "https://api.pandascore.co/ow/matches/upcoming";
        String result = restTemplate.getForObject(uri, String.class);
        System.out.println(result);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<PandaMatch> getTestMatch() {
        RestTemplate restTemplate = new RestTemplate();
        String uri = "https://api.pandascore.co/ow/matches/20502?token=KkzVUEMJ_pTaGQvbtRQo7YQewGzIauH1XqUEWwuRC-KQVQWg8U0";
        PandaMatch result = restTemplate.getForObject(uri, PandaMatch.class);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
