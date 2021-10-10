package com.itprofaceshow.controller;

import com.itprofaceshow.converter.DTOEntityConverter;
import com.itprofaceshow.dto.MessageDTO;
import com.itprofaceshow.dto.RoomDTO;
import com.itprofaceshow.dto.UserDTO;
import com.itprofaceshow.entity.UserEntity;
import com.itprofaceshow.repository.RoomRepository;
import com.itprofaceshow.service.IRoomService;
import com.itprofaceshow.service.IUserService;
import com.itprofaceshow.service.impl.MessageService;
import com.itprofaceshow.service.impl.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class MainController {

    @Autowired
    private IUserService userService;

    @Autowired
    private MessageService messageService;

    @GetMapping(value = "/test")
    public UserDTO test(HttpServletRequest request, @RequestParam String username) {
        UserDTO userDto = userService.findById(username);
        return userDto;
    }

    @MessageMapping("/send-message-to-room")
    public void sendMessage(MessageDTO messageDto) {
        messageService.sendMessageToRoom(messageDto);
    }

    @MessageMapping("/send-invite-message")
    public void sendInviteMessage(MessageDTO messageDto) {
        messageService.sendInviteMessage(messageDto);
    }
}
