package com.iAKIN.CreditSystem.service.impl;

import com.iAKIN.CreditSystem.exception.NotFoundException;
import com.iAKIN.CreditSystem.model.CreditResult;
import com.iAKIN.CreditSystem.model.CreditScore;
import com.iAKIN.CreditSystem.model.Customer;
import com.iAKIN.CreditSystem.repository.CreditScoreRepository;
import com.iAKIN.CreditSystem.service.CustomerService;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class CreditServiceImplTest {

    @Mock
    private CreditScoreRepository creditScoreRepository;
    @Mock
    private CustomerService customerService;
    @InjectMocks
    private CreditServiceImpl creditService;

    // @BeforeEach
    // public void setup() {
    //     // Init
    // }

    @Test
    void getCredit_false() throws Exception {
        // Init step
        CreditScore credit = new CreditScore();
        credit.setScore(10.0);
        Customer customer = new Customer();
        customer.setId("1");
        customer.setMonthlyIncome(100.0);
        // stub - when
        Mockito.when(creditScoreRepository.findById("1")).thenReturn(Optional.of(credit));

        // then
        CreditResult creditResult = creditService.getCredit(customer);

        Assertions.assertEquals(creditResult.getResult(), false);
    }

    @Test
    void getCredit_true_income_lt_5000() throws Exception {
        // Init step
        CreditScore credit = new CreditScore();
        credit.setScore(600.0);
        Customer customer = new Customer();
        customer.setId("1");
        customer.setMonthlyIncome(100.0);
        // stub - when
        Mockito.when(creditScoreRepository.findById("1")).thenReturn(Optional.of(credit));

        // then
        CreditResult creditResult = creditService.getCredit(customer);

        Assertions.assertEquals(creditResult.getResult(), true);
    }

    @Test
    void getCredit_true_income_gt_5000() throws Exception {
        // Init step
        CreditScore credit = new CreditScore();
        credit.setScore(600.0);
        Customer customer = new Customer();
        customer.setId("1");
        customer.setMonthlyIncome(6000.0);
        // stub - when
        Mockito.when(creditScoreRepository.findById("1")).thenReturn(Optional.of(credit));

        // then
        CreditResult creditResult = creditService.getCredit(customer);

        Assertions.assertEquals(creditResult.getResult(), true);
    }

    @Test
    void getCredit_true_score_gt_1000() throws Exception {
        // Init step
        CreditScore credit = new CreditScore();
        credit.setScore(1100.0);
        Customer customer = new Customer();
        customer.setId("1");
        customer.setMonthlyIncome(6000.0);
        // stub - when
        Mockito.when(creditScoreRepository.findById("1")).thenReturn(Optional.of(credit));

        // then
        CreditResult creditResult = creditService.getCredit(customer);

        Assertions.assertEquals(creditResult.getResult(), true);
    }

    @Test
    void getCredit_not_found() {
        Customer customer = new Customer();
        customer.setId("1");
        // stub - when step
        Mockito.when(creditScoreRepository.findById("1")).thenReturn(Optional.empty());

        // valid step
        Assert.assertThrows(NotFoundException.class, () -> {
            // then step
            creditService.getCredit(customer);
        });
    }
}