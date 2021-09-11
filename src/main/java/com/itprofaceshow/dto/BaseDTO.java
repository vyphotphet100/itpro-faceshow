package com.itprofaceshow.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter @Setter
public class BaseDTO {
    private Date createdDate;
    private String createdBy;
    private Date modifiedDate;
    private String modifiedBy;
}
