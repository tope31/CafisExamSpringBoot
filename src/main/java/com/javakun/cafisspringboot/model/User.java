package com.javakun.cafisspringboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String username;
    private String password;
    private String lastName;
    private String firstName;
    private String middleName;
    private Date birthdate;

}
