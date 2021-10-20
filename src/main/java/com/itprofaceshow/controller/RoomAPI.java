package com.itprofaceshow.controller;

import com.itprofaceshow.dto.RoomDTO;
import com.itprofaceshow.service.impl.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class RoomAPI {
    @Autowired
    private RoomService roomService;

    @GetMapping(value = "/room/{id}/get-user-status")
    public RoomDTO getUserStatus(HttpServletRequest request, @PathVariable("id") String id) {
        return roomService.getUserStatus(request, id);
    }

    @PostMapping(value = "/room/create-room")
    public RoomDTO createRoom(HttpServletRequest request) {
        return roomService.save(request);
    }

    @PostMapping(value = "/room/{roomId}/remove-user/{username}")
    public RoomDTO removeUser(HttpServletRequest request, @PathVariable String roomId, @PathVariable String username) {
        return roomService.removeUser(request, roomId, username);
    }
}
