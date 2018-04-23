package com.ourowproject.owproject.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ourowproject.owproject.entities.User;
import com.ourowproject.owproject.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static java.util.Collections.singletonList;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private ObjectMapper mapper;
    private User mockUser;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

        mapper = new ObjectMapper();
        mockUser = new User();
        mockUser.setId(1L);
        mockUser.setBestStreak(10L);
        mockUser.setCurrentStreak(5L);
    }

    @Test
    public void getAllUsersTest() throws Exception {
        Iterable<User> userList = singletonList(mockUser);
        ResponseEntity<Iterable<User>> response = new ResponseEntity<>(userList, OK);

        when(userService.getAllUsers()).thenReturn(response);

        mockMvc.perform(get("/users")).andExpect(status().isOk());

        verify(userService, times(1)).getAllUsers();
    }
}
