package com.iAKIN.CreditSystem.model;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Validated
@Table(name = "customer")
public class Customer {
    @Id
    @NotBlank(message = "id can not be null")
    @Column(name = "id", nullable = false, length = 11)
    private String id;

    @NotBlank(message = "name can not be null")
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @NotBlank(message = "surname can not be null")
    @Column(name = "surname", nullable = false, length = 25)
    private String surname;

    @NotNull(message = "monthly income can not be null")
    @Column(name = "monthly_income", nullable = false)
    private Double monthlyIncome;

    @NotBlank(message = "email can not be null")
    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @NotBlank(message = "phone can not be null")
    @Column(name = "phone", nullable = false, length = 25)
    private String phone;
}