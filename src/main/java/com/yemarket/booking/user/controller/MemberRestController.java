package com.yemarket.booking.user.controller;

import com.yemarket.booking.user.domain.Member;
import com.yemarket.booking.user.domain.MemberRegisterDto;
import com.yemarket.booking.user.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MemberRestController {
    private final MemberService memberService;

    @PostMapping(value = "/register")
    public ResponseEntity<?> register(@RequestBody @Valid MemberRegisterDto dto) {
        return ResponseEntity.ok(memberService.register(dto));
    }

    @PostMapping(value = "/dupChkEmail")
    public boolean dupChkEmail(@RequestBody String email) {
        return memberService.dupChkEmail(email);
    }
}

