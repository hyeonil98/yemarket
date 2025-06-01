package com.yemarket.booking.user.repository;

import com.yemarket.booking.user.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepositoryImpl implements MemberCustomRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean existsByEmail(String email) {
        Long count = (Long) em.createQuery(
                "SELECT COUNT(u) FROM Member u WHERE u.email = :email"
        ).setParameter("email", email)
                .getSingleResult();
        return count > 0;
    }

    @Override
    public Member findByUserId(String email) {
        String jpql = "SELECT u FROM Member u WHERE u.email = :email";
        return em.createQuery(jpql, Member.class).setParameter("email", email).getSingleResult();
    }
}
