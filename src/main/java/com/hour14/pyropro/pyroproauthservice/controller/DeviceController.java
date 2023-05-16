package com.hour14.pyropro.pyroproauthservice.controller;

import com.hour14.pyropro.pyroproauthservice.dto.DeviceDto;
import com.hour14.pyropro.pyroproauthservice.dto.UserDto;
import com.hour14.pyropro.pyroproauthservice.dto.datatable.DataTableRequest;
import com.hour14.pyropro.pyroproauthservice.dto.datatable.DataTableResponse;
import com.hour14.pyropro.pyroproauthservice.service.DeviceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Intellij.
 * Author: Abhishek Peiris
 * Date: 06/05/2023
 * Time: 10:25
 */

@RestController
@RequestMapping(value = "/api/device")
@Slf4j
@CrossOrigin
public class DeviceController {

    @Autowired
    DeviceService deviceService;


    @PostMapping()
    public ResponseEntity<DeviceDto> saveDevice(@RequestBody DeviceDto deviceDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(deviceService.saveDevice(deviceDto));
    }


    @PostMapping("/get")
    public DataTableResponse<DeviceDto> getUsersForDataTable(@RequestBody DataTableRequest dataTableRequest) {

        System.out.println("value - ");

        System.out.println(" -- dataTableRequest -- " + dataTableRequest.toString());

//        return userService.getUsers(dataTableRequest);
        return deviceService.getDevices(dataTableRequest);
    }
}
