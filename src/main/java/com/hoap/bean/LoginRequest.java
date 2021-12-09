package com.hoap.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    @Column(name = "userid")
    @NotNull(message = "User Id is required")
    @Size(min = 1, max = 100)
    String email;

    @Column(name = "password")
    @NotNull(message = "Password is required")
    String password;

}

