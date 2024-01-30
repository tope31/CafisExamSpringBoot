package com.javakun.cafisspringboot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Date;
@Data
public class UserDTO {
    private String lastName;
    private String firstName;
    private String middleName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy",timezone = "GMT+08:00")
    private Date birthdate;
}
