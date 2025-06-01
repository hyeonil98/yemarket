package com.yemarket.booking.user;

import com.yemarket.booking.user.domain.Member;
import com.yemarket.booking.user.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final MemberRepository memberRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        boolean b = memberRepository.existsByEmail(email);
        if(!b){
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다");
        }

        Member findMember = memberRepository.findByUserId(email);

        return new CustomUserDetails(findMember);
    }
}
