package com.hour14.pyropro.pyroproauthservice.service.impl;


import com.hour14.pyropro.pyroproauthservice.dto.UserRoleDto;
import com.hour14.pyropro.pyroproauthservice.exception.DataNotFoundException;
import com.hour14.pyropro.pyroproauthservice.exception.GeneralException;
import com.hour14.pyropro.pyroproauthservice.repository.UserRoleRepository;
import com.hour14.pyropro.pyroproauthservice.service.UserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.hour14.pyropro.pyroproauthservice.constant.ErrorMessage.GENERAL_ERROR;
import static com.hour14.pyropro.pyroproauthservice.constant.ErrorMessage.USER_ROLE_NOT_FOUND;


@Service
@Slf4j
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public List<UserRoleDto> getUserRoles() {
        try {
            return userRoleRepository.findAll()
                    .stream().map(userRole -> userRole.toDto(UserRoleDto.class))
                    .collect(Collectors.toList());

        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new GeneralException(GENERAL_ERROR);
        }
    }

    @Override
    public UserRoleDto getUserRole(int id) {
        return userRoleRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(USER_ROLE_NOT_FOUND))
                .toDto(UserRoleDto.class);

    }
}
