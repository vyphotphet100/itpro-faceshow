package com.itprofaceshow.service;

import com.itprofaceshow.dto.UserDTO;

public interface IUserService extends IBaseService{
    UserDTO findAll();
    UserDTO getById(String username);
    UserDTO save(UserDTO userDto);
    UserDTO update(UserDTO userDto);
    UserDTO delete(String username);
}
