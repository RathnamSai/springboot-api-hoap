package com.hoap.controller;

import com.hoap.bean.SignupRequest;
import com.hoap.exception.GenericStatusBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class LoginController {
    @GetMapping("/auth")
    public String getAllUsers() {
        return " Hello";
    }
}