package com.yemarket.booking.user.repository;

import com.yemarket.booking.user.domain.User;

public interface UserCustomRepository {
    boolean existsByUserId(String userId);

    User findByUserId(String userId);
}
