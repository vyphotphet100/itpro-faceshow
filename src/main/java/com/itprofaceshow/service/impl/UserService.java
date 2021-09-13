package com.itprofaceshow.service.impl;

import com.itprofaceshow.dto.UserDTO;
import com.itprofaceshow.entity.UserEntity;
import com.itprofaceshow.repository.UserRepository;
import com.itprofaceshow.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService implements IUserService {
    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDTO findAll() {
        UserDTO userDto = new UserDTO();
        for (UserEntity userEntity: userRepo.findAll())
            userDto.getResultList().add(converter.toDTO(userEntity, UserDTO.class));

        return userDto;
    }

    @Override
    public UserDTO findById(String username) {
        return null;
    }

    @Override
    public UserDTO save(UserDTO userDto) {
        return null;
    }

    @Override
    public UserDTO update(UserDTO userDto) {
        return null;
    }

    @Override
    public UserDTO delete(String username) {
        return null;
    }
}
