package com.itprofaceshow.dto;

import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class MessageDTO extends BaseDTO{

    private Long id;
    private String content;
    private String userUsername;
    private Long roomId;
}
