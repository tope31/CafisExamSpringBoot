package com.javakun.cafisspringboot.controller;

import com.javakun.cafisspringboot.model.UserDTO;
import com.javakun.cafisspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ResponseEntity<UserDTO> userLogin() {
        return new ResponseEntity<>(userService.login(), HttpStatus.OK);
    }

}
