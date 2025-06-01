package com.yemarket.booking.user.repository;

import com.yemarket.booking.user.domain.Member;

public interface MemberCustomRepository {
    boolean existsByEmail(String email);

    Member findByUserId(String email);
}
