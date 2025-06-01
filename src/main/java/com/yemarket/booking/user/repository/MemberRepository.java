package com.yemarket.booking.user.repository;

import com.yemarket.booking.user.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>,  MemberCustomRepository{
}
