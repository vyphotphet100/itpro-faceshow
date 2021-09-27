package com.itprofaceshow.service.impl;

import com.itprofaceshow.dto.MessageDTO;
import com.itprofaceshow.dto.MessageDTO;
import com.itprofaceshow.entity.MessageEntity;
import com.itprofaceshow.entity.MessageEntity;
import com.itprofaceshow.repository.MessageRepository;
import com.itprofaceshow.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService extends BaseService implements IMessageService {
    @Autowired
    private MessageRepository messageRepo;

    @Override
    public MessageDTO findAll() {
        MessageDTO messageDto = new MessageDTO();
        for (MessageEntity messageEntity: messageRepo.findAll())
            messageDto.getResultList().add(converter.toDTO(messageEntity, MessageDTO.class));

        messageDto.setMessage("Get list of messages successfully.");
        return messageDto;
    }

    @Override
    public MessageDTO findById(Long id) {
        MessageEntity messageEntity = messageRepo.findById(id).orElse(null);
        if (messageEntity == null)
            return (MessageDTO)exceptionObject(new MessageDTO(), "This message does not exist.");

        MessageDTO messageDto = converter.toDTO(messageEntity, MessageDTO.class);
        messageDto.setMessage("Get message having id = " + id + " successfully.");
        return messageDto;
    }

    @Override
    public MessageDTO save(MessageDTO messageDto) {
        MessageEntity messageEntity = messageRepo.findById(messageDto.getId()).orElse(null);
        if (messageEntity != null)
            return (MessageDTO)exceptionObject(new MessageDTO(), "This message exists already.");

        messageEntity = converter.toEntity(messageDto, MessageEntity.class);
        MessageDTO resDto = converter.toDTO(messageRepo.save(messageEntity), MessageDTO.class);
        resDto.setMessage("Creating a message successfully.");
        return resDto;
    }

    @Override
    public MessageDTO update(MessageDTO messageDto) {
        MessageEntity messageEntity = messageRepo.findById(messageDto.getId()).orElse(null);
        if (messageEntity == null)
            return (MessageDTO)exceptionObject(new MessageDTO(), "This message does not exist.");

        messageEntity = converter.toEntity(messageDto, MessageEntity.class);
        MessageDTO resDto = converter.toDTO(messageRepo.save(messageEntity), MessageDTO.class);
        resDto.setMessage("Update message successfully.");
        return resDto;
    }

    @Override
    public MessageDTO delete(Long id) {
        if (!messageRepo.existsById(id))
            return (MessageDTO)exceptionObject(new MessageDTO(), "This message does not exist.");

        messageRepo.deleteById(id);
        MessageDTO resDto = new MessageDTO();
        resDto.setMessage("Update message successfully.");
        return resDto;
    }
}
