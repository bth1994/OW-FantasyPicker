package com.ourowproject.owproject.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ourowproject.owproject.entities.Team;
import com.ourowproject.owproject.entities.User;
import com.ourowproject.owproject.services.TeamService;
import com.ourowproject.owproject.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static java.util.Collections.singletonList;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TeamControllerTest {
    private MockMvc mockMvc;

    @MockBean
    private TeamService teamService;

    @InjectMocks
    private TeamController teamController;

    private ObjectMapper mapper;
    private Team mockTeam;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(teamController).build();
        mapper = new ObjectMapper();
        mockTeam = new Team();
        mockTeam.setId(1L);
        mockTeam.setName("DallasFuel");
        mockTeam.setWinRecord(15L);
        mockTeam.setLossRecord(13L);
    }

    @Test
    public void getAllTeamsTest() throws Exception {
        Iterable<Team> teamList = singletonList(mockTeam);
        ResponseEntity<Iterable<Team>> expectedResponse = new ResponseEntity<>(teamList, OK);
        when(teamService.getAllTeams()).thenReturn(expectedResponse);
        mockMvc.perform(get("/teams")).andExpect(status().isOk())
                        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
        ;
        verify(teamService, times(1)).getAllTeams();
    }

    @Test
    public void getTeamByIdTest() throws Exception {
        ResponseEntity<Team> expectedResponse = new ResponseEntity<>(mockTeam, OK);
        when(teamService.getTeamById(isA(Long.class))).thenReturn(expectedResponse);
        mockMvc.perform(get("/teams/1")).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));

        verify(teamService, times(1)).getTeamById(1L);
    }

    @Test
    public void createTeamTest() throws Exception {
        Team testTeam = new Team();
        testTeam.setId(2L);
        testTeam.setName("What");
        testTeam.setLossRecord(14L);
        testTeam.setWinRecord(13L);
        String body = mapper.writeValueAsString(testTeam);
        when(teamService.createTeam(testTeam)).thenReturn(mock(ResponseEntity.class));
        mockMvc.perform(post("/teams").contentType(MediaType.APPLICATION_JSON)
                .content(body)).andExpect(status().isOk());
    }

    @Test
    public void updateTeamTest() throws Exception {
        Team testTeam1 = new Team();
        testTeam1.setId(3L);
        testTeam1.setName("What up");
        testTeam1.setLossRecord(14L);
        testTeam1.setWinRecord(13L);
        String body = mapper.writeValueAsString(mockTeam);
        ResponseEntity<Team> expectedResponse = new ResponseEntity<>(mockTeam, OK);
        when(teamService.updateTeam(testTeam1)).thenReturn(expectedResponse);
        mockMvc.perform(put("/teams").contentType(MediaType.APPLICATION_JSON)
            .content(body)).andExpect(status().isOk());
    }
}
