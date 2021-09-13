package com.itprofaceshow.service.impl;

import com.itprofaceshow.converter.DTOEntityConverter;
import com.itprofaceshow.dto.BaseDTO;
import com.itprofaceshow.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

public class BaseService implements IBaseService {
    @Autowired
    protected DTOEntityConverter converter;

    @Override
    public BaseDTO exceptionObject(BaseDTO dto, String message) {
        dto.setHttpStatus(HttpStatus.FORBIDDEN);
        dto.setMessage(message);
        return dto;
    }
}
