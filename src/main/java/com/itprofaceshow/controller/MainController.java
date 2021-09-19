package com.itprofaceshow.controller;

import com.itprofaceshow.dto.UserDTO;
import com.itprofaceshow.entity.UserEntity;
import com.itprofaceshow.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping(value = "/test")
    public UserDTO test2() {
        UserDTO userDto = new UserDTO();
        userDto.setUsername("userTest");
        UserDTO userDto2 = userService.save(userDto);
        return userDto2;
    }
}
