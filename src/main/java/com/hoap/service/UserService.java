package com.hoap.service;

import com.hoap.bean.SignupRequest;
import com.hoap.exception.GenericStatusBean;
import com.hoap.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    GenericStatusBean findByEmail(String email);
    GenericStatusBean getAllUsers();
    GenericStatusBean save(SignupRequest signupRequest);
}
