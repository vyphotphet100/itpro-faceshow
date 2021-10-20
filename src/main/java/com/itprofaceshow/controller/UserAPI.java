package com.itprofaceshow.controller;

import com.itprofaceshow.dto.MessageDTO;
import com.itprofaceshow.dto.UserDTO;
import com.itprofaceshow.repository.MessageRepository;
import com.itprofaceshow.service.impl.MessageService;
import com.itprofaceshow.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserAPI {
    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    @PostMapping(value = "/user/log-in")
    public UserDTO login(@RequestBody UserDTO userDto) {
        if (userDto.getUsername() == null || userDto.getPassword() == null)
            return (UserDTO) userService.exceptionObject(userDto, "Username or Password is empty.");

        return userService.login(userDto.getUsername(), userDto.getPassword());
    }

    @PostMapping(value = "/user/create-account")
    public UserDTO creatAccount(@RequestBody UserDTO userDto) {
        if (userDto.getUsername() == null ||
            userDto.getPassword() == null ||
            userDto.getFullName() == null)
            return (UserDTO)userService.exceptionObject(userDto, "Some fields are empty. Please check again.");

        return userService.save(userDto);
    }

    @PostMapping(value = "/user/update-profile")
    public UserDTO update(@RequestBody UserDTO userDto) {
        return userService.update(userDto);
    }

    @GetMapping(value = "/user/{username}/get-profile")
    public UserDTO getProfile(@PathVariable String username) {
        return userService.findById(username);
    }

    @MessageMapping("/user/send-message-to-room")
    public void sendMessage(MessageDTO messageDto) {
        messageService.sendMessageToRoom(messageDto);
    }

    @MessageMapping("/user/send-invite-message")
    public void sendInviteMessage(MessageDTO messageDto) {
        messageService.sendInviteMessage(messageDto);
    }

    @PostMapping("/user/join-room/{roomId}/{hiddenPassword}")
    public UserDTO joinRoom(HttpServletRequest request, @PathVariable String roomId, @PathVariable String hiddenPassword) {
        return userService.joinRoom(request, roomId, hiddenPassword);
    }
}
