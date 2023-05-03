package com.hour14.pyropro.pyroproauthservice.controller;


import com.hour14.pyropro.pyroproauthservice.dto.UserRoleDto;
import com.hour14.pyropro.pyroproauthservice.service.UserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user-role")
@Slf4j
@CrossOrigin
public class UserRoleController {

    @Autowired
    UserRoleService userRoleService;

    @GetMapping
    public ResponseEntity<List<UserRoleDto>> getUserRoles(){
        return ResponseEntity.ok(userRoleService.getUserRoles());
    }


    @GetMapping("{roleId}")
    public ResponseEntity<UserRoleDto> getUserRole(@PathVariable(value = "roleId") int roleId){
        return ResponseEntity.ok(userRoleService.getUserRole(roleId));
    }

}
