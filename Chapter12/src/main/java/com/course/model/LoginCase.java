package com.course.model;

import lombok.Data;

@Data
public class LoginCase {
    private int id;
    private String password;
    private String userName;
    private String expected;
}
