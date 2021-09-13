package com.itprofaceshow.service;

import com.itprofaceshow.dto.RoomDTO;

public interface IRoomService extends IBaseService{
    RoomDTO findAll();
    RoomDTO findById(Long id);
    RoomDTO save(RoomDTO roomDto);
    RoomDTO update(RoomDTO roomDto);
    RoomDTO delete(Long id);
}
