package com.yemarket.booking.user.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterDto {
    private String userId;
    private String password;
    private String email;
    private String telNum;
}
