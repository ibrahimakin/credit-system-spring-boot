package com.iAKIN.CreditSystem.service;

import com.iAKIN.CreditSystem.model.Customer;

public interface CustomerService {
    Boolean create(Customer customer);
    Boolean update(Customer customer);
    Boolean delete(Customer customer);
}