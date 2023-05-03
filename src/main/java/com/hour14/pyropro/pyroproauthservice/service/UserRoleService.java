package com.hour14.pyropro.pyroproauthservice.service;


import com.hour14.pyropro.pyroproauthservice.dto.UserRoleDto;

import java.util.List;

public interface UserRoleService {

    List<UserRoleDto> getUserRoles();

    UserRoleDto getUserRole(int id);
}
