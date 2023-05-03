package com.hour14.pyropro.pyroproauthservice.controller;


import com.hour14.pyropro.pyroproauthservice.dto.UserDto;
import com.hour14.pyropro.pyroproauthservice.dto.datatable.DataTableRequest;
import com.hour14.pyropro.pyroproauthservice.dto.datatable.DataTableResponse;
import com.hour14.pyropro.pyroproauthservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-08-11
 * Time: 15:31
 */
@RestController
@RequestMapping(value = "/api/user")
@Slf4j
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping()
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(userDto));
    }


    @PutMapping
    public ResponseEntity<UserDto> updateUser(
            @RequestBody UserDto userDto) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(userDto));
    }


    @DeleteMapping("{userId}")
    public ResponseEntity<UserDto> removeUser(
            @PathVariable(value = "userId") int userId){
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.removeUser(userId));
    }


    @PostMapping("/get")
    public DataTableResponse<UserDto> getUsersForDataTable(@RequestBody DataTableRequest dataTableRequest) {

        System.out.println("value - ");

        System.out.println(" -- dataTableRequest -- " + dataTableRequest.toString());

//        return userService.getUsers(dataTableRequest);
        return userService.getUsers(dataTableRequest);
    }
}
