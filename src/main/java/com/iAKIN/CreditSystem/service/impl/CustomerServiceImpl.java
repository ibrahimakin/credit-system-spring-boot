package com.iAKIN.CreditSystem.service.impl;

import com.iAKIN.CreditSystem.model.Customer;
import com.iAKIN.CreditSystem.repository.CustomerRepository;
import com.iAKIN.CreditSystem.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public Boolean create(Customer customer) {
        customerRepository.save(customer);
        return true;
    }

    @Override
    public Boolean update(Customer customer) {
        return null;
    }

    @Override
    public Boolean delete(Customer customer) {
        return null;
    }
}
