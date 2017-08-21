package com.pavel.permits.permits.model;

import lombok.Data;

/**
 * Created by Pavel on 21.08.2017.
 */
@Data
public class Person {
    private Integer id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Position position;
    private Organization organization;
}
