package com.hour14.pyropro.pyroproauthservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hour14.pyropro.pyroproauthservice.util.Transformer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;

/**
 * Created by Intellij.
 * Author: Abhishek Peiris
 * Date: 06/05/2023
 * Time: 10:10
 */
@Getter
@Setter
@ToString
public class DeviceDto implements Transformer {

    private int id;

    @JsonProperty("device_id")
    private String deviceId;

    private int lat;


    private int lan;


    private String district;
}
