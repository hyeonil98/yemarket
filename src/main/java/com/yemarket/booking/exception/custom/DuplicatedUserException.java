package com.yemarket.booking.exception.custom;

import com.yemarket.booking.exception.ErrorCode;

public class DuplicatedUserException extends RuntimeException {
    public DuplicatedUserException() {
        super(ErrorCode.DUPLICATED_USER.getMessage());
    }
}
