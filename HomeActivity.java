package com.sdaproject.frugalflowapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG = "HomeActivity";

    private Button btnCalculateTransactions;
    private Button btnSelectCategory;
    private Button btnViewIncome;
    private Button btnViewExpense;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Existing button setup code...
        setupCalculateTransactionsButton();
        setupSelectCategoryButton();
        setupViewIncomeButton();
        setupViewExpenseButton();
    }

    private void setupCalculateTransactionsButton() {
        btnCalculateTransactions = findViewById(R.id.btnCalculateTransactions);
        if (btnCalculateTransactions != null) {
            btnCalculateTransactions.setOnClickListener(v -> {
                try {
                    Intent intent = new Intent(HomeActivity.this, MainActivityA.class);
                    startActivity(intent);
                    Log.d(TAG, "Successfully started MainActivity");
                } catch (Exception e) {
                    Log.e(TAG, "Error starting MainActivity", e);
                    Toast.makeText(this, "Could not open transactions: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Log.e(TAG, "Calculate Transactions button not found in layout");
            Toast.makeText(this, "Error: Transactions button not initialized", Toast.LENGTH_SHORT).show();
        }
    }

    private void setupSelectCategoryButton() {
        btnSelectCategory = findViewById(R.id.btnSelectCategory);
        if (btnSelectCategory != null) {
            btnSelectCategory.setOnClickListener(v -> {
                try {
                    Intent intent = new Intent(HomeActivity.this, CategoryExploreActivity.class);
                    startActivity(intent);
                    Log.d(TAG, "Successfully started CategoryExploreActivity");
                } catch (Exception e) {
                    Log.e(TAG, "Error starting CategoryExploreActivity", e);
                    Toast.makeText(this, "Could not open categories: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Log.e(TAG, "Select Category button not found in layout");
            Toast.makeText(this, "Error: Category button not initialized", Toast.LENGTH_SHORT).show();
        }
    }

    private void setupViewIncomeButton() {
        btnViewIncome = findViewById(R.id.btnViewIncome);
        if (btnViewIncome != null) {
            btnViewIncome.setOnClickListener(v -> {
                try {
                    Intent intent = new Intent(HomeActivity.this, IncomeActivity.class);
                    startActivity(intent);
                    Log.d(TAG, "Successfully started IncomeActivity");
                } catch (Exception e) {
                    Log.e(TAG, "Error starting IncomeActivity", e);
                    Toast.makeText(this, "Could not open income view: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Log.e(TAG, "View Income button not found in layout");
            Toast.makeText(this, "Error: Income view button not initialized", Toast.LENGTH_SHORT).show();
        }
    }

    private void setupViewExpenseButton() {
        btnViewExpense = findViewById(R.id.btnViewExpenses);
       /* if (btnViewExpense != null) {
            btnViewExpense.setOnClickListener(v -> {
                try {
                    Intent intent = new Intent(HomeActivity.this, ExpenseActivity.class);
                    startActivity(intent);
                    Log.d(TAG, "Successfully started ExpenseActivity");
                } catch (Exception e) {
                    Log.e(TAG, "Error starting ExpenseActivity", e);
                    Toast.makeText(this, "Could not open expense view: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Log.e(TAG, "View Expense button not found in layout");
            Toast.makeText(this, "Error: Expense view button not initialized", Toast.LENGTH_SHORT).show();
        } */
    }
}