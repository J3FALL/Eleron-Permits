package com.pavel.permits.permits.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * Created by Pavel on 24.08.2017.
 */
//TODO: personName = FIO
@Data
public class PermitDto {

    private Integer id;

    @JsonProperty("person_id")
    private Integer personId;

    @JsonProperty("person_first_name")
    private String personFirstName;

    @JsonProperty("person_middle_name")
    private String personMiddleName;

    @JsonProperty("person_last_name")
    private String personLastName;

    @JsonProperty("person_org")
    private String personOrganizationName;

    @JsonProperty("person_position")
    private String personPositionName;

    @JsonProperty("code_ids")
    private List<Integer> codeIds;

    @JsonProperty("pass_id")
    private Integer passId;

    @JsonProperty("pass_name")
    private String passName;

    @JsonProperty("issue_date")
    private Date issueDate;

    @JsonProperty("expired_date")
    private Date expiredDate;

    @JsonProperty("agreedDate")
    private Date agreedDate;
}
