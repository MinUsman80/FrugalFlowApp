package com.sdaproject.frugalflowapp;

public class IncomeSource {
    private String name;
    private String amount;
    private String growth;

    public IncomeSource(String name, String amount, String growth) {
        this.name = name;
        this.amount = amount;
        this.growth = growth;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getGrowth() {
        return growth;
    }

    public void setGrowth(String growth) {
        this.growth = growth;
    }
}