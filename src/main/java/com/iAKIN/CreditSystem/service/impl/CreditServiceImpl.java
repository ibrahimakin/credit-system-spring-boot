package com.iAKIN.CreditSystem.service.impl;

import com.iAKIN.CreditSystem.model.CreditResult;
import com.iAKIN.CreditSystem.model.CreditScore;
import com.iAKIN.CreditSystem.model.Customer;
import com.iAKIN.CreditSystem.repository.CreditScoreRepository;
import com.iAKIN.CreditSystem.service.CreditService;
import com.iAKIN.CreditSystem.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreditServiceImpl implements CreditService {
    private final CreditScoreRepository creditScoreRepository;
    private final CustomerService customerService;

    private final Integer LIMIT_MULTIPLIER = 4;

    @Override
    public CreditResult getCredit(Customer customer) throws Exception {
        Optional<CreditScore> creditScore = creditScoreRepository.findById(customer.getId());
        if (creditScore.isPresent()) {
            customerService.create(customer);
            Double score = creditScore.get().getScore();
            if (score < 500) {
                return new CreditResult(false, "Your loan application has been rejected.", 0.0, new Date());
            } else if (score < 1000){
                if (customer.getMonthlyIncome() < 5000) {
                    return new CreditResult(true, "Your loan application has been approved.", 10000.0, new Date());
                } else {
                    return new CreditResult(true, "Your loan application has been approved.", 20000.0, new Date());
                }
            } else {
                return new CreditResult(true, "Your loan application has been approved.", customer.getMonthlyIncome() * LIMIT_MULTIPLIER, new Date());
            }
        } else {
            throw new Exception("Score not found");
        }
    }
}