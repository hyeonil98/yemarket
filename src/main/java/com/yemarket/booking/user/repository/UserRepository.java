package com.yemarket.booking.user.repository;

import com.yemarket.booking.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>,  UserCustomRepository{
}
