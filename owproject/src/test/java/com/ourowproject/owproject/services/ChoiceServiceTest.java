package com.ourowproject.owproject.services;

import com.ourowproject.owproject.entities.Choice;
import com.ourowproject.owproject.entities.Match;
import com.ourowproject.owproject.entities.User;
import com.ourowproject.owproject.repositories.ChoiceRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static java.util.Collections.singleton;
import static java.util.Collections.singletonList;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

public class ChoiceServiceTest {

    @Mock
    private ChoiceRepository choiceRepository;

    @InjectMocks
    private ChoiceService choiceService;

    private Choice testChoice;
    private Match testMatch;
    private User testUser;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        testChoice = new Choice();
        testChoice.setId(1L);

        testMatch = new Match();
        testMatch.setMatchID(2L);

        testUser = new User();
        testUser.setId(3L);
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
    public void getAllChoicesBymatch_idTest() {
        Iterable<Choice> choiceList = singletonList(testChoice);
        when(choiceRepository.getAllChoicesBymatchID(isA(Long.class))).thenReturn(choiceList);

        ResponseEntity<Iterable<Choice>> expected = new ResponseEntity<>(choiceList, OK);
        ResponseEntity<Iterable<Choice>> actual = choiceService.getAllChoicesBymatch_id(testMatch.getMatchID());

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllChoicesByuser_id() {
        Iterable<Choice> choiceList = singleton(testChoice);
        when(choiceRepository.getAllChoicesByuserID(isA(Long.class))).thenReturn(choiceList);

        ResponseEntity<Iterable<Choice>> expected = new ResponseEntity<>(choiceList, OK);
        ResponseEntity<Iterable<Choice>> actual = choiceService.getAllChoicesByuser(testUser.getId());

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
        when(choiceRepository.save(isA(Choice.class))).thenReturn(testChoice);

        ResponseEntity<Choice> expected = new ResponseEntity<>(testChoice, CREATED);
        ResponseEntity<Choice> actual = choiceService.createChoice(testChoice);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void updateChoiceTest() {
        when(choiceRepository.save(isA(Choice.class))).thenReturn(testChoice);

        ResponseEntity<Choice> expected = new ResponseEntity<>(testChoice, OK);
        ResponseEntity<Choice> actual = choiceService.updateChoice(testChoice);

        Assert.assertEquals(expected, actual);
    }
}
