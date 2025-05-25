package com.yemarket.booking.user.repository;

public interface UserCustomRepository {
    boolean existsByUserId(String userId);
}
