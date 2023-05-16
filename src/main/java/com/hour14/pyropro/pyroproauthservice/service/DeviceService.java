package com.hour14.pyropro.pyroproauthservice.service;

import com.hour14.pyropro.pyroproauthservice.dto.DeviceDto;
import com.hour14.pyropro.pyroproauthservice.dto.UserDto;
import com.hour14.pyropro.pyroproauthservice.dto.datatable.DataTableRequest;
import com.hour14.pyropro.pyroproauthservice.dto.datatable.DataTableResponse;

/**
 * Created by Intellij.
 * Author: Abhishek Peiris
 * Date: 06/05/2023
 * Time: 10:10
 */
public interface DeviceService {

    DeviceDto saveDevice(DeviceDto deviceDto);

    DeviceDto updateDevice(DeviceDto deviceDto);

    DeviceDto getDevice(int id);

    DeviceDto removeDevice(int id);

    DataTableResponse<DeviceDto> getDevices(DataTableRequest dataTableRequest);
}
