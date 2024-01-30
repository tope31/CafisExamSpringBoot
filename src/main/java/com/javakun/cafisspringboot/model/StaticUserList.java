package com.javakun.cafisspringboot.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class StaticUserList {
    public static List<User> users = new ArrayList<>();
    static {
        users.add(new User("jdelacruz", "25d55ad283aa400af464c76d713c07ad", "Dela Cruz", "Juan", "A", Date.valueOf("2000-01-01")));
        users.add(new User("pmanaloto", "25d55ad283aa400af464c76d713c07ad", "Manaloto", "Pepito", "N", Date.valueOf("2000-02-02")));
    }
}
