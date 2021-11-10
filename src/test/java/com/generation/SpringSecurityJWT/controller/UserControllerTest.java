package com.generation.SpringSecurityJWT.controller;

import com.generation.SpringSecurityJWT.model.User;
import com.generation.SpringSecurityJWT.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @Test
    @DisplayName("Pruebas UserController save")
    void saveTest(){
        // verificar que el UserService haya sido llamado el método save.
        UserService userService = mock(UserService.class);
        BCryptPasswordEncoder bCryptPasswordEncoder = mock(BCryptPasswordEncoder.class);
        UserController userController = new UserController(userService, bCryptPasswordEncoder);

        User user = new User();

        user.setName("Francisco");
        user.setUsername("fco@banuelos.com");
        user.setPassword("432432");
        user.setAddress("Zacatecas");
        user.setSurname("Val");

        when(userService.save(any(User.class))).thenReturn(user);
        User response = userController.saveUser(user);

        verify(userService, times(1)).save(any(User.class));

        verify(bCryptPasswordEncoder, atLeastOnce()).encode("432432");

        assertEquals(user.getName(), response.getName());
    }

}