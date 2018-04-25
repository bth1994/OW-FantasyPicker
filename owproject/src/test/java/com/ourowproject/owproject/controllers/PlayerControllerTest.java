package com.ourowproject.owproject.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ourowproject.owproject.entities.Player;
import com.ourowproject.owproject.services.PlayerService;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PlayerControllerTest {

    private MockMvc mockMvc;

    @MockBean
    private PlayerService playerService;

    @InjectMocks
    private PlayerController playerController;

    private ObjectMapper om;
    private Player mockPlayer;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(playerController).build();

        om = new ObjectMapper();
        mockPlayer = new Player();
        mockPlayer.setId(14L);
        mockPlayer.setName("Thighmou");
        mockPlayer.setTeamID(1414L);
        mockPlayer.setSlug("Taimou");
    }

    @Test
    public void getAllPlayerTests() throws Exception {
        Iterable<Player> playerList = singletonList(mockPlayer);
        ResponseEntity<Iterable<Player>> expectedResponse = new ResponseEntity<>(playerList, OK);
        when(playerService.getAllPlayers()).thenReturn(expectedResponse);
        mockMvc.perform(get("/players")).andExpect(status().isOk());
        verify(playerService, times(1)).getAllPlayers();
    }

    @Test
    public void getPlayerByPlayerIdTest() throws Exception {
        ResponseEntity<Player> expectedResponse = new ResponseEntity<>(mockPlayer, OK);
        when(playerService.getPlayerByplayerID(isA(Long.class))).thenReturn(expectedResponse);
        mockMvc.perform(get("/players/1")).andExpect(status().isOk());
        verify(playerService, times(1)).getPlayerByplayerID(1L);
    }

    @Test
    public void findAllPlayersByTeamIdTest() throws Exception {
        Iterable<Player> playerList = singletonList(mockPlayer);
        ResponseEntity<Iterable<Player>> expectedResponse = new ResponseEntity<>(playerList, OK);
        when(playerService.findAllPlayersByteamID(isA(Long.class))).thenReturn(expectedResponse);
        mockMvc.perform(get("/players/1414/team")).andExpect(status().isOk());
        verify(playerService, times(1)).findAllPlayersByteamID(1414L);
    }

    @Test
    public void createPlayerTest() throws Exception {
        String body = om.writeValueAsString(mockPlayer);
        when(playerService.createPlayer(mockPlayer)).thenReturn(mock(ResponseEntity.class));
        mockMvc.perform(post("/players")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body)).andExpect(status().isOk());
    }
    @Test
    public void updatePlayerTest() throws Exception {
        String body = om.writeValueAsString(mockPlayer);
        when(playerService.updatePlayer(mockPlayer)).thenReturn(mock(ResponseEntity.class));
        mockMvc.perform(put("/players")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body)).andExpect(status().isOk());
    }
}
