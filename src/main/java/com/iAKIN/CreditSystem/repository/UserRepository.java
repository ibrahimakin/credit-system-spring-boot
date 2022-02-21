package com.iAKIN.CreditSystem.repository;

import com.iAKIN.CreditSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    boolean existsByUsername(String username);
    void deleteByUsername(String username);
}