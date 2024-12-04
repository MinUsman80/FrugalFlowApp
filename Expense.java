package com.sdaproject.frugalflowapp;

public class Expense {
    private String description;
    private double totalAmount;
    private ExpenseCategory category;
    private String date; // Keeping date as a String type

    // Constructor with all parameters
    public Expense(String description, double totalAmount, ExpenseCategory category, String date) {
        this.description = description;
        this.totalAmount = totalAmount;
        this.category = category;
        this.date = date.toString(); // Convert Date to String

    }

    // Getters and setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public ExpenseCategory getCategory() {
        return category;
    }

    public void setCategory(ExpenseCategory category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}