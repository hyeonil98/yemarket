package com.yemarket.booking.user.service;

import com.yemarket.booking.exception.custom.DuplicatedUserException;
import com.yemarket.booking.user.domain.Member;
import com.yemarket.booking.user.domain.MemberRegisterDto;
import com.yemarket.booking.user.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public Member register(MemberRegisterDto dto) {
        String email = dto.getEmail();
        if (memberRepository.existsByEmail(email)) {
            throw new DuplicatedUserException();
        }

        Member member = Member.builder()
                .password(dto.getPassword())
                .telNum(dto.getTelNum())
                .email(dto.getEmail())
                .build();

        return memberRepository.save(member);
    }

    public Member getMember(Long idx) {
        return memberRepository.findById(idx).orElseThrow();
    }

    public boolean dupChkEmail(String email) {
        return memberRepository.existsByEmail(email);
    }

}
