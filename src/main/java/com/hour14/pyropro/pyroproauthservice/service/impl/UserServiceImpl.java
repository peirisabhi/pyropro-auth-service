package com.hour14.pyropro.pyroproauthservice.service.impl;


import com.hour14.pyropro.pyroproauthservice.dto.UserDto;
import com.hour14.pyropro.pyroproauthservice.dto.datatable.DataTableRequest;
import com.hour14.pyropro.pyroproauthservice.dto.datatable.DataTableResponse;
import com.hour14.pyropro.pyroproauthservice.exception.DataNotFoundException;
import com.hour14.pyropro.pyroproauthservice.exception.DuplicateDataFoundException;
import com.hour14.pyropro.pyroproauthservice.exception.GeneralException;
import com.hour14.pyropro.pyroproauthservice.model.User;
import com.hour14.pyropro.pyroproauthservice.repository.UserRepository;
import com.hour14.pyropro.pyroproauthservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.hour14.pyropro.pyroproauthservice.constant.ErrorMessage.*;


/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-08-11
 * Time: 13:58
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto saveUser(UserDto userDto) {

        try {
            final User user = userDto.toEntity(User.class);
            user.setRegisteredAt(new Date());
            user.setStatus(1);

            return userRepository.save(user)
                    .toDto(UserDto.class);
        } catch (DataIntegrityViolationException e) {
            log.error(e.getLocalizedMessage());
            throw new DuplicateDataFoundException(USER_ALREADY_EXISTS);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new GeneralException(GENERAL_ERROR);
        }
    }

    @Override
    public UserDto updateUser(UserDto userDto) {

        final User user = userRepository.findById(userDto.getId())
                .orElseThrow(() -> new DataNotFoundException(USER_NOT_FOUND));

        try {
            user.setFname(userDto.getFname());
            user.setLname(userDto.getLname());
            user.setEmail(userDto.getEmail());
            user.setGender(userDto.getGender());
            user.setNic(userDto.getNic());
            user.setUserRoleId(userDto.getUserRoleId());

            return userRepository.save(user)
                    .toDto(UserDto.class);
        } catch (DataIntegrityViolationException e) {
            log.error(e.getLocalizedMessage());
            throw new DuplicateDataFoundException(USER_ALREADY_EXISTS);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new GeneralException(GENERAL_ERROR);
        }

    }

    @Override
    public UserDto getUser(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(USER_NOT_FOUND))
                .toDto(UserDto.class);
    }

    @Override
    public UserDto removeUser(int id) {
        final User user = userRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(USER_NOT_FOUND));

        try {
            user.setStatus(0);

            return userRepository.save(user)
                    .toDto(UserDto.class);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new GeneralException(GENERAL_ERROR);
        }
    }

    @Override
    public DataTableResponse<UserDto> getUsers(DataTableRequest dataTableRequest) {
        final String value = dataTableRequest.getSearch().getValue();
        final List<UserDto> userDtoList = userRepository.findAllByStatus(1)
                .stream()
                .filter(user ->
                        String.valueOf(user.getId()).startsWith(value)
                                || user.getFname().startsWith(value)
                                || user.getLname().startsWith(value)
                                || user.getGender().startsWith(value)
                                || user.getEmail().startsWith(value)

                )
                .map((user) -> {
                    final UserDto userDto = user.toDto(UserDto.class);
//                    userDto.
                    return userDto;
                })
                .collect(Collectors.toList());

        DataTableResponse<UserDto> userDataTableResponse = new DataTableResponse<>();

        userDataTableResponse.setData(userDtoList);
        userDataTableResponse.setDraw(dataTableRequest.getDraw());
        userDataTableResponse.setRecordsTotal(userDtoList.size());
        userDataTableResponse.setRecordsFiltered(userDtoList.size());

        return userDataTableResponse;

    }
}
