package com.pavel.permits.permits.model;

import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * Created by Pavel on 21.08.2017.
 */
@Data
public class Permit {
    private Integer id;
    private Person person;
    private List<Code> codes;
    private Pass pass;
    private Date issueDate;
    private Date expiredDate;
    private Date agreedDate;
}
