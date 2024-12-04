package com.sdaproject.frugalflowapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AddBudgetActivity extends AppCompatActivity {
    static ArrayList<String> budgetList = new ArrayList<>();
    static ArrayList<String> amountList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_budget);

        EditText budgetName = findViewById(R.id.budget_name);
        EditText budgetAmount = findViewById(R.id.budget_amount);
        Button saveBudgetButton = findViewById(R.id.save_budget_button);

        saveBudgetButton.setOnClickListener(v -> {
            String name = budgetName.getText().toString();
            String amount = budgetAmount.getText().toString();

            if (!name.isEmpty() && !amount.isEmpty()) {
                budgetList.add(name);
                amountList.add(amount);
                Toast.makeText(this, "Budget Added!", Toast.LENGTH_SHORT).show();
                budgetName.setText("");
                budgetAmount.setText("");
            } else {
                Toast.makeText(this, "Please fill all fields.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}