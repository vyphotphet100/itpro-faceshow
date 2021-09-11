package com.itprofaceshow.dto;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class UserDTO extends BaseDTO{
    private String username;
    private String password;
    private String fullName;
    private String address;
    private String avatar;
    private String phone;
    private String status;
    private List<Long> roomIds = new ArrayList<>();
    private List<Long> messageIds = new ArrayList<>();
}
