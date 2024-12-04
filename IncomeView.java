package com.sdaproject.frugalflowapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class IncomeView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Find the View Income button
        Button btnViewIncome = findViewById(R.id.btnViewIncome);
        Button btnViewExpenses = findViewById(R.id.btnViewExpenses);
        Button btnSelectCategory = findViewById(R.id.btnSelectCategory);
        Button btnCalculateTransactions = findViewById(R.id.btnCalculateTransactions);
        Button btnViewReport = findViewById(R.id.btnViewReport);

        // Set click listener to navigate to Income View
        btnViewIncome.setOnClickListener(v -> {
            Intent intent = new Intent(IncomeView.this, IncomeActivity.class);
            startActivity(intent);
        });

        // Add other button click listeners as needed
        btnViewExpenses.setOnClickListener(v -> {
            // TODO: Implement Expenses Activity
        });

        btnSelectCategory.setOnClickListener(v -> {
            // TODO: Implement Category Selection
        });

        btnCalculateTransactions.setOnClickListener(v -> {
            // TODO: Implement Transaction Calculation
        });

        btnViewReport.setOnClickListener(v -> {
            // TODO: Implement Financial Report
        });
    }
}