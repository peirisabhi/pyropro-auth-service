package com.hour14.pyropro.pyroproauthservice.service;



import com.hour14.pyropro.pyroproauthservice.dto.UserDto;
import com.hour14.pyropro.pyroproauthservice.dto.datatable.DataTableRequest;
import com.hour14.pyropro.pyroproauthservice.dto.datatable.DataTableResponse;

import java.util.List;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-08-11
 * Time: 13:52
 */
public interface UserService {

    UserDto saveUser(UserDto userDto);

    UserDto updateUser(UserDto userDto);

    UserDto getUser(int id);

    UserDto removeUser(int id);

    DataTableResponse<UserDto> getUsers(DataTableRequest dataTableRequest);

}
