package com.hoap.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hoap.bean.LoginRequest;
import com.hoap.bean.SignupRequest;
import com.hoap.exception.GenericStatusBean;
import com.hoap.repository.UserRepository;
import com.hoap.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;

@RestController
//@Transactional
@RequestMapping("/hoap")
public class UserRegistrationController {
    private static final Logger logger = LogManager.getLogger(UserRegistrationController.class);

    private UserService userService;

    @Autowired
    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers(@Valid @RequestBody SignupRequest signupRequest) {
        GenericStatusBean gsBean = userService.getAllUsers();
        logger.info("User Info Retrieved:: {}  " , gsBean);
        return new ResponseEntity<>(gsBean, gsBean!=null ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> userRegistration(@Valid @RequestBody SignupRequest signupRequest) {
        GenericStatusBean gsBean = userService.save(signupRequest);
        logger.info("User is Registered :: {}  " , gsBean);
        return new ResponseEntity<>(gsBean, gsBean!=null ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }


    @PostMapping("/{email}")
    public ResponseEntity<GenericStatusBean> userSign(@Valid @RequestBody LoginRequest loginRequest,
                                                      @RequestParam("email") String email)  {
        GenericStatusBean gsBean = userService.findByEmail(email);
        logger.info("User is LoggedIn :: {}  " , gsBean);
        return new ResponseEntity<>(gsBean, gsBean!=null ? HttpStatus.OK : HttpStatus.BAD_REQUEST);

    }


}
