package com.hour14.pyropro.pyroproauthservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hour14.pyropro.pyroproauthservice.util.Transformer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * Created by Intellij.
 * Author: abhishekpeiris
 * Date: 2022-08-11
 * Time: 13:53
 */
@Getter
@Setter
@ToString
public class UserDto implements Transformer {

    private int id;

    private String fname;

    private String lname;

    private String email;

    private String gender;

    private String nic;

    @JsonProperty("registered_at")
    private Date registeredAt;

    @JsonProperty("user_role_id")
    private int userRoleId;

    private String userRole;


}
