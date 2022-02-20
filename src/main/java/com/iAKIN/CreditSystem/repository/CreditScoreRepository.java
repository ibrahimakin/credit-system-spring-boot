package com.iAKIN.CreditSystem.repository;

import com.iAKIN.CreditSystem.model.CreditScore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditScoreRepository extends JpaRepository<CreditScore, String> { }