package com.hour14.pyropro.pyroproauthservice.controller;

import com.hour14.pyropro.pyroproauthservice.dto.UserRoleDto;
import com.hour14.pyropro.pyroproauthservice.model.UserRole;
import com.hour14.pyropro.pyroproauthservice.repository.UserRoleRepository;
import com.hour14.pyropro.pyroproauthservice.service.UserRoleService;
import com.hour14.pyropro.pyroproauthservice.service.impl.UserRoleServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.Optional;

/**
 * Created by Intellij.
 * Author: Abhishek Peiris
 * Date: 03/05/2023
 * Time: 07:42
 */
//@RunWith(SpringRunner.class)
//@WebMvcTest(UserController.class)
//@ExtendWith(SpringExtension.class)
public class UserRoleControllerTest {

   private UserRoleDto expectedUserDto;

    @MockBean
   private UserRoleService userRoleService;

    @Mock
   private UserRoleRepository userRoleRepository;


    @BeforeEach
    void setUp() {
//        userRoleRepository = Mockito.mock(UserRoleRepository.class);

        MockitoAnnotations.openMocks(this);
        userRoleService = new UserRoleServiceImpl(userRoleRepository);

//        expectedUserDto = Mockito.mock(UserRoleDto.class);
    }


    @Test
    public void find() throws Exception {
//        expectedUserDto.setRole("admin");
//        expectedUserDto.setId(1);
//        Mockito.when(userRoleRepository.findById(expectedUserDto.getId()))
//                .thenReturn(Optional.of(expectedUserDto));
//        City actual = cityService.find(expectedUserDto.getId());
//        ReflectionAssert.assertReflectionEquals(expected, actual);

        UserRole expected = new UserRole(1, "admin");
        Mockito.when(userRoleRepository.findById(expected.getId()))
                .thenReturn(Optional.of(expected));

        UserRoleDto actual = userRoleService.getUserRole(expected.getId());
        Assert.assertEquals(expected, actual);

    }

}
