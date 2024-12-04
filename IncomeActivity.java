package com.sdaproject.frugalflowapp;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class IncomeActivity extends AppCompatActivity {

    private RecyclerView recyclerViewIncomeSources;
    private IncomeSourcesAdapter incomeSourcesAdapter;
    private List<IncomeSource> incomeSources;
    private TextView tvTotalMonthlyIncome;
    private TextView tvIncomeGrowth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_view);

        // Initialize views
        recyclerViewIncomeSources = findViewById(R.id.recyclerViewIncomeSources);
        MaterialButton btnAddIncome = findViewById(R.id.btnAddIncome);
        tvTotalMonthlyIncome = findViewById(R.id.tvTotalMonthlyIncome);
        tvIncomeGrowth = findViewById(R.id.tvIncomeGrowth);

        // Initialize income sources
        incomeSources = getIncomeSources();

        // Setup RecyclerView
        incomeSourcesAdapter = new IncomeSourcesAdapter(incomeSources);
        recyclerViewIncomeSources.setAdapter(incomeSourcesAdapter);
        recyclerViewIncomeSources.setLayoutManager(new LinearLayoutManager(this));

        // Set total income and growth
        updateIncomeSummary();

        // Add Income button click listener
        btnAddIncome.setOnClickListener(v -> showAddIncomeDialog());
    }

    private List<IncomeSource> getIncomeSources() {
        List<IncomeSource> sources = new ArrayList<>();
        sources.add(new IncomeSource("Salary", "$4,000", "+5%"));
        sources.add(new IncomeSource("Freelance", "$800", "+20%"));
        sources.add(new IncomeSource("Investments", "$200", "+15%"));
        return sources;
    }

    private void updateIncomeSummary() {
        double totalIncome = calculateTotalIncome();
        tvTotalMonthlyIncome.setText(String.format("$%.2f", totalIncome));
        tvIncomeGrowth.setText("+12.5%"); // This could be calculated dynamically
    }

    private double calculateTotalIncome() {
        double total = 0;
        for (IncomeSource source : incomeSources) {
            // Remove '$' and parse
            String amountStr = source.getAmount().replace("$", "").replace(",", "");
            total += Double.parseDouble(amountStr);
        }
        return total;
    }

    private void showAddIncomeDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Add Income Source");

        // Inflate dialog layout
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_add_income, null);
        dialogBuilder.setView(dialogView);

        // Get dialog views
        TextInputEditText etIncomeName = dialogView.findViewById(R.id.etIncomeName);
        TextInputEditText etIncomeAmount = dialogView.findViewById(R.id.etIncomeAmount);

        dialogBuilder.setPositiveButton("Add", (dialog, which) -> {
            String name = etIncomeName.getText() != null ? etIncomeName.getText().toString() : "";
            String amount = etIncomeAmount.getText() != null ? etIncomeAmount.getText().toString() : "";

            if (!name.isEmpty() && !amount.isEmpty()) {
                IncomeSource newSource = new IncomeSource(name, "$" + amount, "+0%");
                incomeSources.add(newSource);
                incomeSourcesAdapter.notifyItemInserted(incomeSources.size() - 1);
                updateIncomeSummary();
            }
        });

        dialogBuilder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());

        dialogBuilder.create().show();
    }
}