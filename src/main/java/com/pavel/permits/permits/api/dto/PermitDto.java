package com.pavel.permits.permits.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * Created by Pavel on 24.08.2017.
 */

@Data
public class PermitDto {

    private Integer id;

    @JsonProperty("person_id")
    private Integer personId;

    @JsonProperty("code_ids")
    private List<Integer> codeIds;

    @JsonProperty("pass_id")
    private Integer passId;

    @JsonProperty("issue_date")
    private Date issueDate;

    @JsonProperty("expired_date")
    private Date expiredDate;

    @JsonProperty("agreedDate")
    private Date agreedDate;
}
