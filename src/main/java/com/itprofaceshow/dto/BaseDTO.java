package com.itprofaceshow.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter @Setter
public class BaseDTO {
    private Date createdDate;
    private String createdBy;
    private Date modifiedDate;
    private String modifiedBy;

    private HttpStatus httpStatus;
    private String message;
    private List<Object> requestList = new ArrayList<>();
    private List<Object> resultList = new ArrayList<>();
}
