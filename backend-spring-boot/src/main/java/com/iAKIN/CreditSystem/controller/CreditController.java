package com.iAKIN.CreditSystem.controller;

import com.iAKIN.CreditSystem.model.Customer;
import com.iAKIN.CreditSystem.service.CreditService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/credit")
public class CreditController {

    private final CreditService creditService;

    @PostMapping(value = "")
    public ResponseEntity<?> getCredit(@Valid @RequestBody Customer customer) throws Exception {
        return new ResponseEntity<>(creditService.getCredit(customer), HttpStatus.OK);
    }
}
