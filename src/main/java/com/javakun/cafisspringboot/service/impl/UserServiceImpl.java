package com.javakun.cafisspringboot.service.impl;

import com.javakun.cafisspringboot.exception.LoginFailedException;
import com.javakun.cafisspringboot.mapper.UserMapper;
import com.javakun.cafisspringboot.model.User;
import com.javakun.cafisspringboot.model.UserDTO;
import com.javakun.cafisspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import static com.javakun.cafisspringboot.model.StaticUserList.users;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO login() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return userMapper.toLoginDto(user);
            }
        }
        throw new LoginFailedException();
    }

}
