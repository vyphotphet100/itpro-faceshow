package com.itprofaceshow.controller;

import com.itprofaceshow.dto.UserDTO;
import com.itprofaceshow.entity.UserEntity;
import com.itprofaceshow.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private IUserService userService;

    @GetMapping(value = "/test")
    public UserDTO test() {
        UserDTO userDto = userService.findAll();
        return userDto;
    }
}
