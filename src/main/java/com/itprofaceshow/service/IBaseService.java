package com.itprofaceshow.service;

import com.itprofaceshow.converter.DTOEntityConverter;
import com.itprofaceshow.dto.BaseDTO;
import org.springframework.beans.factory.annotation.Autowired;

public interface IBaseService {
    BaseDTO exceptionObject(BaseDTO dto, String message);

}
