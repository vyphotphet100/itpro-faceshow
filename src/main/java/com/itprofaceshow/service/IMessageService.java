package com.itprofaceshow.service;

import com.itprofaceshow.dto.MessageDTO;

public interface IMessageService extends IBaseService{
    MessageDTO findAll();
    MessageDTO getById(Long id);
    MessageDTO save(MessageDTO messageDto);
    MessageDTO update(MessageDTO messageDto);
    MessageDTO delete(Long id);
}
