package com.itprofaceshow.service;

import com.itprofaceshow.dto.RoomDTO;

import javax.servlet.http.HttpServletRequest;

public interface IRoomService extends IBaseService{
    RoomDTO findAll();
    RoomDTO findById(Long id);
    RoomDTO save(HttpServletRequest request); // create room
    RoomDTO update(RoomDTO roomDto);
    RoomDTO delete(Long id);

    RoomDTO getUserStatus(HttpServletRequest request, Long id);
    RoomDTO addUser(HttpServletRequest request, Long roomId, String username);
    RoomDTO removeUser(HttpServletRequest request, Long roomId, String username);
}
