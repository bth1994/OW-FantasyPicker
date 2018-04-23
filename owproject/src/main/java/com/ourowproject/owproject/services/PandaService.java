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
}
