package com.hour14.pyropro.pyroproauthservice.service.impl;

import com.hour14.pyropro.pyroproauthservice.dto.UserRoleDto;
import com.hour14.pyropro.pyroproauthservice.model.UserRole;
import com.hour14.pyropro.pyroproauthservice.repository.UserRoleRepository;
import com.hour14.pyropro.pyroproauthservice.service.UserRoleService;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.rules.ExpectedException;
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
 * Time: 08:13
 */

@ExtendWith(SpringExtension.class)
public class UserRoleServiceImplTest {

    private UserRoleService userRoleService;

    @Mock
    private UserRoleRepository userRoleRepository;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @BeforeEach
    void setUp() {
        userRoleService = new UserRoleServiceImpl(userRoleRepository);
    }


    @Test
    void getUserRolesTest() {
        UserRole expected = new UserRole(1, "admin");
        List<UserRole> userRoles = new ArrayList<>();
        userRoles.add(expected);

        List<Optional<UserRole>> convertedList  = userRoles.stream()
                .map((o) -> Optional.of(o))
                .collect(Collectors.toList());

        Mockito.when(userRoleRepository.findAll())
                .thenReturn(userRoles);

        List<UserRoleDto> actual = userRoleService.getUserRoles();
        Assert.assertEquals(actual.get(0).getId(), actual.get(0).getId());

    }


    @Test
    void getUserRolesByIdTest() {

        UserRole expected = new UserRole(1, "admin");
        Mockito.when(userRoleRepository.findById(expected.getId()))
                .thenReturn(Optional.of(expected));

        UserRoleDto actual = userRoleService.getUserRole(expected.getId());
        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getRole(), actual.getRole());

    }



    @Test
    void getUserRolesTrowExceptionTest() {
        exception.expect(NullPointerException.class);

        Mockito.when(userRoleRepository.findAll())
                .thenThrow(new NullPointerException("constructor failed"));

    }

}
