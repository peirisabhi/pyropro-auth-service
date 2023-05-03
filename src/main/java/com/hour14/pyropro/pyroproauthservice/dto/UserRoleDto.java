package com.hour14.pyropro.pyroproauthservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hour14.pyropro.pyroproauthservice.util.Transformer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserRoleDto implements Transformer {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int id;

    private String role;
}
