package com.yemarket.booking.user.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserCustomRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean existsByUserId(String userId) {
        Long count = (Long) em.createQuery(
                "SELECT COUNT(u) FROM User u WHERE u.userId = :userId"
        ).setParameter("userId", userId)
                .getSingleResult();
        return count > 0;
    }
}
