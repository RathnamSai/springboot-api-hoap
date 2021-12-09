package com.hoap.bean;

import lombok.Data;

@Data
public class SignupRequest {
    String firstName;
    String lastName;
    String email;
    String password;
}