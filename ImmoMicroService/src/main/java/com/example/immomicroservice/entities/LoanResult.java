package com.example.immomicroservice.entities;

import java.util.List;

public class LoanResult {
    private double monthlyPayment;
    private List<Investissement> top3Investments;

    public LoanResult(double monthlyPayment, List<Investissement> top3Investments) {
        this.monthlyPayment = monthlyPayment;
        this.top3Investments = top3Investments;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public List<Investissement> getTop3Investments() {
        return top3Investments;
    }

}
