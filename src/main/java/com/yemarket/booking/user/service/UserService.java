package com.yemarket.booking.user.service;

import com.yemarket.booking.exception.custom.DuplicatedUserException;
import com.yemarket.booking.user.domain.User;
import com.yemarket.booking.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public User register(String userId, String password, String email, String telNum) {
        if (userRepository.existsByUserId(userId)) {
            throw new DuplicatedUserException();
        }

        User user = User.builder()
                .userId(userId)
                .password(password)
                .email(email)
                .telNum(telNum)
                .build();

        return userRepository.save(user);
    }

    public User getUser(Long idx) {
        return userRepository.findById(idx).orElseThrow();
    }
}
