package com.ourowproject.owproject.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ourowproject.owproject.entities.Choice;
import com.ourowproject.owproject.services.ChoiceService;
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

import static java.util.Collections.singletonList;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ChoiceControllerTest {

    private MockMvc mockMvc;
    private Choice testChoice;
    private ObjectMapper mapper;

    @MockBean
    private ChoiceService choiceService;

    @InjectMocks
    private ChoiceController choiceController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(choiceController).build();

        mapper = new ObjectMapper();

        testChoice = new Choice();
        testChoice.setId(14L);
    }

    @Test
    public void getAllChoicesTest() throws Exception {
        Iterable<Choice> choices = singletonList(testChoice);
        ResponseEntity<Iterable<Choice>> responseEntity = new ResponseEntity<>(choices, HttpStatus.OK);

        when(choiceService.getAllChoices()).thenReturn(responseEntity);

        mockMvc.perform(get("/choices")).andExpect(status().isOk());

        verify(choiceService, times(1)).getAllChoices();
    }

    @Test
    public void getChoiceByIdTest() throws Exception {
        ResponseEntity<Choice> responseEntity = new ResponseEntity<>(testChoice, HttpStatus.OK);

        when(choiceService.getChoiceById(testChoice.getId())).thenReturn(responseEntity);

        mockMvc.perform(get("/choices/14")).andExpect(status().isOk());

        verify(choiceService, times(1)).getChoiceById(isA(Long.class));
    }

    @Test
    public void createChoiceTest() throws Exception {
        ResponseEntity<Choice> responseEntity = new ResponseEntity<>(testChoice, HttpStatus.CREATED);
        String body = mapper.writeValueAsString(testChoice);

        when(choiceService.createChoice(testChoice)).thenReturn(responseEntity);

        mockMvc.perform(post("/choices")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isOk());

        verify(choiceService, times(1)).createChoice(isA(Choice.class));
    }

    @Test
    public void updateChoiceTest() throws Exception {
        ResponseEntity<Choice> responseEntity = new ResponseEntity<>(testChoice, HttpStatus.OK);
        String body = mapper.writeValueAsString(testChoice);

        when(choiceService.updateChoice(testChoice)).thenReturn(responseEntity);

        mockMvc.perform(put("/choices")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isOk());

        verify(choiceService, times(1)).updateChoice(isA(Choice.class));
    }



}
