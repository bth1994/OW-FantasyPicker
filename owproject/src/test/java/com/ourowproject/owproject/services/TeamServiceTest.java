package com.ourowproject.owproject.services;

import com.ourowproject.owproject.entities.Team;
import com.ourowproject.owproject.repositories.TeamRepository;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TeamServiceTest {

    @Mock
    private TeamRepository teamRepository;

    @InjectMocks
    private TeamService teamService;

    private Team testTeam;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        testTeam.setId(1L);
    }
}
