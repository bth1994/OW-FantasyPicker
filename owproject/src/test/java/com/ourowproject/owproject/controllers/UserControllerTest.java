package com.ourowproject.owproject.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ourowproject.owproject.entities.User;
import com.ourowproject.owproject.services.UserService;
import org.assertj.core.internal.bytebuddy.asm.Advice;
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
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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

    @Test
    public void getUserByIdTest() throws Exception {
        ResponseEntity<User> response = new ResponseEntity<>(mockUser, OK);

        when(userService.getUserById(isA(Long.class))).thenReturn(response);

        mockMvc.perform(get("/users/1")).andExpect(status().isOk());

        verify(userService, times(1)).getUserById(1L);
    }

    @Test
    public void getCurrentStreakByUserIdTest() throws Exception {
        ResponseEntity<Long> response = new ResponseEntity<>(mockUser.getCurrentStreak(), OK);

        when(userService.getCurrentStreakByUserId(isA(Long.class))).thenReturn(response);

        mockMvc.perform(get("/users/1/streak")).andExpect(status().isOk());

        verify(userService, times(1)).getCurrentStreakByUserId(1L);
    }

    @Test
    public void getBestStreakByUserId() throws Exception {
        ResponseEntity<Long> response = new ResponseEntity<>(mockUser.getBestStreak(), OK);

        when(userService.getBestStreakByUserId(isA(Long.class))).thenReturn(response);

        mockMvc.perform(get("/users/1/best")).andExpect(status().isOk());

        verify(userService, times(1)).getBestStreakByUserId(1L);
    }

    @Test
    public void createUserTest() throws Exception {
        String body = mapper.writeValueAsString(mockUser);

        when(userService.createUser(mockUser)).thenReturn(mock(ResponseEntity.class));

        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isOk());
    }

    @Test
    public void updateUserTest() throws Exception {
        String body = mapper.writeValueAsString(mockUser);
        ResponseEntity<User> response = new ResponseEntity<>(mockUser, OK);

        when(userService.updateUser(isA(User.class))).thenReturn(response);

        mockMvc.perform(put("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body)).andExpect(status().isOk());
    }

}
