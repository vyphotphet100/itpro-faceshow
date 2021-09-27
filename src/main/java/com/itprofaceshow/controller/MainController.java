package com.itprofaceshow.controller;

import com.itprofaceshow.converter.DTOEntityConverter;
import com.itprofaceshow.dto.RoomDTO;
import com.itprofaceshow.dto.UserDTO;
import com.itprofaceshow.entity.UserEntity;
import com.itprofaceshow.repository.RoomRepository;
import com.itprofaceshow.service.IRoomService;
import com.itprofaceshow.service.IUserService;
import com.itprofaceshow.service.impl.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class MainController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoomService roomService;

    @GetMapping(value = "/test")
    public RoomDTO test(HttpServletRequest request, @RequestParam Long roomId, @RequestParam String username) {
        RoomDTO roomDto = roomService.removeUser(request, roomId, username);
        return roomDto;
    }

    @PostMapping(value = "/test")
    public UserDTO test2() {
        UserDTO userDto = new UserDTO();
        userDto.setUsername("userTest");
        UserDTO userDto2 = userService.save(userDto);
        return userDto2;
    }
}
