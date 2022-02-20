package com.iAKIN.CreditSystem.repository;

import com.iAKIN.CreditSystem.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> { }