package com.ourowproject.owproject.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ourowproject.owproject.entities.Match;
import com.ourowproject.owproject.services.MatchService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static java.util.Collections.singletonList;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MatchControllerTest {

    private MockMvc mockMvc;
    private Match testMatch;
    private ObjectMapper mapper;

    @MockBean
    private MatchService matchService;

    @InjectMocks
    private MatchController matchController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(matchController).build();
        mapper = new ObjectMapper();

        testMatch = new Match();
        testMatch.setMatchID(11L);
    }

    @Test
    public void getAllMatchesTest() throws Exception {
        Iterable<Match> matches = singletonList(testMatch);
        ResponseEntity<Iterable<Match>> responseEntity = new ResponseEntity<>(matches, HttpStatus.OK);

        when(matchService.getAllMatches()).thenReturn(responseEntity);

        mockMvc.perform(get("/matches")).andExpect(status().isOk());

        verify(matchService, times(1)).getAllMatches();
    }

    @Test
    public void getMatchByIdTest() throws Exception {
        ResponseEntity<Match> responseEntity = new ResponseEntity<>(testMatch, HttpStatus.OK);

        when(matchService.getMatchById(11L)).thenReturn(responseEntity);

        mockMvc.perform(get("/matches/11")).andExpect(status().isOk());

        verify(matchService, times(1)).getMatchById(isA(Long.class));
    }

    @Test
    public void createMatchTest() throws Exception {
        ResponseEntity<Match> responseEntity = new ResponseEntity<>(testMatch, HttpStatus.CREATED);
        String body = mapper.writeValueAsString(testMatch);

        when(matchService.createMatch(testMatch)).thenReturn(responseEntity);

        mockMvc.perform(post("/matches")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isOk());

        verify(matchService, times(1)).createMatch(isA(Match.class));
    }

    @Test
    public void updateMatchTest() throws Exception {
        ResponseEntity<Match> responseEntity = new ResponseEntity<>(testMatch, HttpStatus.OK);
        String body = mapper.writeValueAsString(testMatch);

        when(matchService.updateMatch(testMatch)).thenReturn(responseEntity);

        mockMvc.perform(put("/matches")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isOk());

        verify(matchService, times(1)).updateMatch(isA(Match.class));
    }



}
