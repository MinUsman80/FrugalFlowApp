package com.sdaproject.frugalflowapp;

public class ExpenseCategory {
    private String name;
    private int iconResourceId;
    private String color; // Added color field

    // Constructor with all parameters
    public ExpenseCategory(String name, int iconResourceId, String color) {
        this.name = name;
        this.iconResourceId = iconResourceId;
        this.color = color;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIconResourceId() {
        return iconResourceId;
    }

    public void setIconResourceId(int iconResourceId) {
        this.iconResourceId = iconResourceId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}