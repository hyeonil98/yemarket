package com.yemarket.booking.user.controller;

import com.yemarket.booking.user.domain.UserRegisterDto;
import com.yemarket.booking.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/api/v1/users")
@RequiredArgsConstructor
@RestController
public class UserRestController {
    private final UserService userService;

    @PostMapping(value = "/register")
    public ResponseEntity<?> register(UserRegisterDto dto) {
        return userService.register(dto.getUserId(), dto.getPassword(),
                dto.getEmail(), dto.getTelNum());
    }
}
