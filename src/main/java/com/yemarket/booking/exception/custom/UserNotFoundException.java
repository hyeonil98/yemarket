package com.yemarket.booking.exception.custom;

import com.yemarket.booking.exception.ErrorCode;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND.getMessage());
    }
}
