package com.itprofaceshow.controller;

import com.itprofaceshow.converter.DTOEntityConverter;
import com.itprofaceshow.dto.UserDTO;
import com.itprofaceshow.entity.UserEntity;
import com.itprofaceshow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private DTOEntityConverter converter;

    @GetMapping(value = "/test")
    public UserDTO test() {
        UserDTO userDto = new UserDTO();
        userDto.setUsername("user1");
        userDto.getRoomIds().add(1L);
        userDto.getRoomIds().add(2L);
        UserEntity userEntity = converter.toEntity(userDto, UserEntity.class);
        return converter.toDTO(userEntity, UserDTO.class);
    }
}
