package com.itprofaceshow.service.impl;

import com.itprofaceshow.dto.RoomDTO;
import com.itprofaceshow.entity.RoomEntity;
import com.itprofaceshow.repository.RoomRepository;
import com.itprofaceshow.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService extends BaseService implements IRoomService {
    @Autowired
    private RoomRepository roomRepo;

    @Override
    public RoomDTO findAll() {
        RoomDTO roomDto = new RoomDTO();
        for (RoomEntity roomEntity: roomRepo.findAll())
            roomDto.getResultList().add(converter.toDTO(roomEntity, RoomDTO.class));

        roomDto.setMessage("Get list of rooms successfully.");
        return roomDto;
    }

    @Override
    public RoomDTO getById(Long id) {
        RoomEntity roomEntity = roomRepo.getById(id);
        if (roomEntity == null)
            return (RoomDTO)exceptionObject(new RoomDTO(), "This room does not exist.");

        RoomDTO roomDto = converter.toDTO(roomEntity, RoomDTO.class);
        roomDto.setMessage("Get room having id = " + id + " successfully.");
        return roomDto;
    }

    @Override
    public RoomDTO save(RoomDTO roomDto) {
        RoomEntity roomEntity = roomRepo.getById(roomDto.getId());
        if (roomEntity != null)
            return (RoomDTO)exceptionObject(new RoomDTO(), "This room exists already.");

        roomEntity = converter.toEntity(roomDto, RoomEntity.class);
        RoomDTO resDto = converter.toDTO(roomRepo.save(roomEntity), RoomDTO.class);
        resDto.setMessage("Creating a room successfully.");
        return resDto;
    }

    @Override
    public RoomDTO update(RoomDTO roomDto) {
        RoomEntity roomEntity = roomRepo.getById(roomDto.getId());
        if (roomEntity != null)
            return (RoomDTO)exceptionObject(new RoomDTO(), "This room does not exist.");

        roomEntity = converter.toEntity(roomDto, RoomEntity.class);
        RoomDTO resDto = converter.toDTO(roomRepo.save(roomEntity), RoomDTO.class);
        resDto.setMessage("Update room successfully.");
        return resDto;
    }

    @Override
    public RoomDTO delete(Long id) {
        if (!roomRepo.existsById(id))
            return (RoomDTO)exceptionObject(new RoomDTO(), "This room does not exist.");

        roomRepo.deleteById(id);
        RoomDTO roomDto = new RoomDTO();
        roomDto.setMessage("Delete room successfully.");
        return roomDto;
    }
}
