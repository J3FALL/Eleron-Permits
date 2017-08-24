package com.pavel.permits.permits.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Created by Pavel on 24.08.2017.
 */

@Data
public class PersonDto {

    private Integer id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("middle_name")
    private String middleName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("position_id")
    private Integer positionId;

    @JsonProperty("org_id")
    private Integer organizationId;
}
