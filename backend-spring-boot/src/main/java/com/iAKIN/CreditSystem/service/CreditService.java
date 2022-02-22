package com.iAKIN.CreditSystem.service;

import com.iAKIN.CreditSystem.model.CreditResult;
import com.iAKIN.CreditSystem.model.Customer;

public interface CreditService {
    CreditResult getCredit(Customer customer) throws Exception;
}