package com.itprofaceshow.service.impl;

import com.itprofaceshow.dto.UserDTO;
import com.itprofaceshow.entity.UserEntity;
import com.itprofaceshow.repository.UserRepository;
import com.itprofaceshow.service.IUserService;
import com.itprofaceshow.util.JwtUtil;
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

        userDto.setMessage("Get list of users successfully.");
        return userDto;
    }

    @Override
    public UserDTO findById(String username) {
        UserEntity userEntity = userRepo.findById(username).orElse(null);
        if (userEntity == null)
            return (UserDTO)exceptionObject(new UserDTO(), "This username does not exist already.");

        UserDTO userDto = converter.toDTO(userEntity, UserDTO.class);
        userDto.setMessage("Get user having username = " + username + " successfully.");
        return userDto;
    }

    @Override
    public UserDTO save(UserDTO userDto) {
        if (userRepo.existsById(userDto.getUsername()))
            return (UserDTO)this.exceptionObject(new UserDTO(), "This username exists.");

        userDto.setStatus("OFFLINE");
        userDto.setToken(JwtUtil.generateToken(userDto));
        UserEntity userEntity = converter.toEntity(userDto, UserEntity.class);
        UserDTO resDto = converter.toDTO(userRepo.save(userEntity), UserDTO.class);
        resDto.setMessage("Creating an account successfully.");
        return resDto;
    }

    @Override
    public UserDTO update(UserDTO userDto) {
        if (!userRepo.existsById(userDto.getUsername()))
            return (UserDTO)this.exceptionObject(new UserDTO(), "This user does not exist.");

        UserEntity userEntity = converter.toEntity(userDto, UserEntity.class);
        UserDTO resDto = converter.toDTO(userRepo.save(userEntity), UserDTO.class);
        resDto.setMessage("Update successfully.");
        return resDto;
    }

    @Override
    public UserDTO delete(String username) {
        if (!userRepo.existsById(username))
            return (UserDTO)exceptionObject(new UserDTO(), "This user does not exist.");

        userRepo.deleteById(username);
        UserDTO userDto = new UserDTO();
        userDto.setMessage("Delete successfully.");
        return userDto;
    }

    @Override
    public UserDTO login(String username, String password) {
        UserEntity userEntity = userRepo.getByUsernameAndPassword(username, password);
        if (userEntity == null)
            return (UserDTO) exceptionObject(new UserDTO(), "Username or password is incorrect.");

        // recreate token
        String tailToken = JwtUtil.getKeyTokenTail(userEntity.getToken());
        userEntity.setToken(tailToken);
        UserDTO tmpDto = converter.toDTO(userEntity, UserDTO.class);
        userEntity.setToken(JwtUtil.generateToken(tmpDto));
        userEntity = userRepo.save(userEntity);

        UserDTO userDto = converter.toDTO(userEntity, UserDTO.class);
        userDto.setMessage("Login successfully.");
        return userDto;
    }
}
