package com.iAKIN.CreditSystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class CreditResult {
    private Boolean result;
    private String message;
    private Double amount;
    private Date date;
}