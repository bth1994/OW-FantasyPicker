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
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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


}
