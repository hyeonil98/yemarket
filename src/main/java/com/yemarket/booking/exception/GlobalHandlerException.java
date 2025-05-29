package com.yemarket.booking.exception;

import com.yemarket.booking.exception.custom.DuplicatedUserException;
import com.yemarket.booking.exception.custom.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalHandlerException {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleUserNotFoundException(UserNotFoundException e) {
        return errorResponse(ErrorCode.USER_NOT_FOUND);
    }

    @ExceptionHandler(DuplicatedUserException.class)
    public ResponseEntity<?> handleDuplicatedUserException(DuplicatedUserException e) {
        return errorResponse(ErrorCode.DUPLICATED_USER);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidExceptionException(DuplicatedUserException e) {
        return errorResponse(ErrorCode.INTERNAL_ERROR);
    }


    private ResponseEntity<?> errorResponse(ErrorCode code) {
        return ResponseEntity.status(code.getStatus()).body(Map.of(
                "timestamp", LocalDateTime.now(),
                "error", code.name(),
                "message", code.getMessage(),
                "status", code.getStatus().value()
        ));
    }
}
