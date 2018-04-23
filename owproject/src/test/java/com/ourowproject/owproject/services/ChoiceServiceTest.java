package com.ourowproject.owproject.services;

import com.ourowproject.owproject.entities.Choice;
import com.ourowproject.owproject.repositories.ChoiceRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.OK;

public class ChoiceServiceTest {

    @Mock
    private ChoiceRepository choiceRepository;

    @InjectMocks
    private ChoiceService choiceService;

    private Choice testChoice;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        testChoice = new Choice();
        testChoice.setId(1L);
    }

    @Test
    public void getAllChoicesTest() {
        Iterable<Choice> choiceList = new ArrayList<>();
        given(choiceRepository.findAll()).willReturn(choiceList);

        ResponseEntity<Iterable<Choice>> expected = new ResponseEntity<>(choiceList, OK);
        ResponseEntity<Iterable<Choice>> actual = choiceService.getAllChoices();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getChoiceByIdTest() {
        when(choiceRepository.findChoiceById(1L)).thenReturn(testChoice);

        ResponseEntity<Choice> expected = new ResponseEntity<>(testChoice, OK);
        ResponseEntity<Choice> actual = choiceService.getChoiceById(testChoice.getId());

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void createChoiceTest() {

    }
}
