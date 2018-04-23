package com.ourowproject.owproject.services;

import com.ourowproject.owproject.entities.Choice;
import com.ourowproject.owproject.repositories.ChoiceRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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

    }
}
