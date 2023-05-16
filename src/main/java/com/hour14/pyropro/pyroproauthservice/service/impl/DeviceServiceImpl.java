package com.hour14.pyropro.pyroproauthservice.service.impl;

import com.hour14.pyropro.pyroproauthservice.dto.DeviceDto;
import com.hour14.pyropro.pyroproauthservice.dto.UserDto;
import com.hour14.pyropro.pyroproauthservice.dto.datatable.DataTableRequest;
import com.hour14.pyropro.pyroproauthservice.dto.datatable.DataTableResponse;
import com.hour14.pyropro.pyroproauthservice.exception.DuplicateDataFoundException;
import com.hour14.pyropro.pyroproauthservice.exception.GeneralException;
import com.hour14.pyropro.pyroproauthservice.model.Device;
import com.hour14.pyropro.pyroproauthservice.repository.DeviceRepository;
import com.hour14.pyropro.pyroproauthservice.service.DeviceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.hour14.pyropro.pyroproauthservice.constant.ErrorMessage.GENERAL_ERROR;
import static com.hour14.pyropro.pyroproauthservice.constant.ErrorMessage.USER_ALREADY_EXISTS;

/**
 * Created by Intellij.
 * Author: Abhishek Peiris
 * Date: 06/05/2023
 * Time: 10:12
 */
@Service
@Slf4j
public class DeviceServiceImpl implements DeviceService {


    @Autowired
    DeviceRepository deviceRepository;

    @Override
    public DeviceDto saveDevice(DeviceDto deviceDto) {
        try {
            Device device = deviceDto.toEntity(Device.class);
            device.setRegisteredAt(new Date());

           return deviceRepository.save(device)
                    .toDto(DeviceDto.class);

        }catch (DataIntegrityViolationException e) {
            log.error(e.getLocalizedMessage());
            throw new DuplicateDataFoundException(USER_ALREADY_EXISTS);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new GeneralException(GENERAL_ERROR);
        }
    }

    @Override
    public DeviceDto updateDevice(DeviceDto deviceDto) {
        return null;
    }

    @Override
    public DeviceDto getDevice(int id) {
        return null;
    }

    @Override
    public DeviceDto removeDevice(int id) {
        return null;
    }

    @Override
    public DataTableResponse<DeviceDto> getDevices(DataTableRequest dataTableRequest) {
        final String value = dataTableRequest.getSearch().getValue();

        List<DeviceDto> deviceList = deviceRepository.findAll()
                .stream()
                .map((device) -> {
                    return device.toDto(DeviceDto.class);
                })
                .collect(Collectors.toList());


        DataTableResponse<DeviceDto> userDataTableResponse = new DataTableResponse<>();

        userDataTableResponse.setData(deviceList);
        userDataTableResponse.setDraw(dataTableRequest.getDraw());
        userDataTableResponse.setRecordsTotal(deviceList.size());
        userDataTableResponse.setRecordsFiltered(deviceList.size());

        return userDataTableResponse;
    }
}
