package com.iAKIN.CreditSystem.controller;

import com.iAKIN.CreditSystem.model.CreditResult;
import com.iAKIN.CreditSystem.model.Customer;
import com.iAKIN.CreditSystem.service.CreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/credit")
public class CreditController {

    private final CreditService creditService;

    @PostMapping(value = "")
    public CreditResult getCredit(@Valid @RequestBody Customer customer) throws Exception {
        return creditService.getCredit(customer);
    }
}
