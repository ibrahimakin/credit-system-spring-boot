package com.iAKIN.CreditSystem.service.impl;

import com.iAKIN.CreditSystem.model.Customer;
import com.iAKIN.CreditSystem.repository.CustomerRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {
    @Mock
    private CustomerRepository customerRepository;
    @InjectMocks
    private CustomerServiceImpl customerService;

    @Test
    void save() {
        // Init step
        Customer customer = new Customer();
        customer.setId("1");
        customer.setMonthlyIncome(100.0);
        // stub - when
        Mockito.when(customerRepository.save(customer)).thenReturn(customer);

        // then
        Boolean b = customerService.save(customer);

        Assert.assertEquals(b, true);
    }
}