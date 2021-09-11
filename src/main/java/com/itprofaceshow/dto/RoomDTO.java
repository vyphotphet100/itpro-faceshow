package com.itprofaceshow.dto;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class RoomDTO extends BaseDTO{
    private Long id;
    private String hostUserUsername;
    private List<Long> messageIds = new ArrayList<>();
}
