package com.iAKIN.CreditSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "credit_score")
public class CreditScore {
    @Id
    @Column(name = "customer_id", nullable = false, length = 11)
    private String customerId;

    @Column(name = "score", nullable = false)
    private Double score;

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}