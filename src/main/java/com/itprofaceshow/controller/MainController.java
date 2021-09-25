package com.itprofaceshow.controller;

import com.itprofaceshow.converter.DTOEntityConverter;
import com.itprofaceshow.dto.UserDTO;
import com.itprofaceshow.entity.UserEntity;
import com.itprofaceshow.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @Autowired
    private IUserService userService;

    @Autowired
    private DTOEntityConverter converter;

    @GetMapping(value = "/test")
    public UserDTO test(@RequestParam String username, @RequestParam String password) {
        UserDTO userDto = new UserDTO();
        userDto.setUsername(username);
        userDto.setPassword(password);
        userDto.setFullName("Cao Dinh Sy Vy");
        userDto = userService.save(userDto);
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
