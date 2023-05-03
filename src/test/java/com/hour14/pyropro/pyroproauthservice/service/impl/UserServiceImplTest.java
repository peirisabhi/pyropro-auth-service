package com.hour14.pyropro.pyroproauthservice.service.impl;

import com.hour14.pyropro.pyroproauthservice.dto.UserDto;
import com.hour14.pyropro.pyroproauthservice.dto.UserRoleDto;
import com.hour14.pyropro.pyroproauthservice.model.User;
import com.hour14.pyropro.pyroproauthservice.model.UserRole;
import com.hour14.pyropro.pyroproauthservice.repository.UserRepository;
import com.hour14.pyropro.pyroproauthservice.service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Intellij.
 * Author: Abhishek Peiris
 * Date: 03/05/2023
 * Time: 09:05
 */
@ExtendWith(SpringExtension.class)
public class UserServiceImplTest {

    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userService = new UserServiceImpl(userRepository);
    }


    @Test
    void getUserTest() {
        User expected = new User();
        expected.setId(1);

        Mockito.when(userRepository.findById(expected.getId()))
                .thenReturn(Optional.of(expected));

        UserDto actual = userService.getUser(expected.getId());
        Assert.assertEquals(actual.getId(), actual.getId());

    }

}
