package com.sdaproject.frugalflowapp; // Replace with your package name

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ActivitySetCurrency extends AppCompatActivity {

    // Declare UI elements
    private Spinner currencySpinner;
    private Button saveCurrencyButton;

    // Array of currencies
    private final String[] currencies = {"PKR - Pakistani Rupee", "SAR - Saudi Riyal", "USD - US Dollar"};
    private String selectedCurrency = ""; // Variable to store the selected currency

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_currency); // Replace with your XML file name

        // Initialize UI elements
        currencySpinner = findViewById(R.id.currency_spinner);
        saveCurrencyButton = findViewById(R.id.save_currency_button);

        // Set up Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, currencies);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        currencySpinner.setAdapter(adapter);

        // Handle Spinner item selection
        currencySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedCurrency = currencies[position]; // Save selected currency
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Optionally handle case when no selection is made
            }
        });

        // Handle Save button click
        saveCurrencyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!selectedCurrency.isEmpty()) {
                    Toast.makeText(ActivitySetCurrency.this, "Currency Set to: " + selectedCurrency, Toast.LENGTH_SHORT).show();

                    // Navigate to the next page (e.g., cash balance setup page)
                    Intent intent = new Intent(ActivitySetCurrency.this, ActivitySetCashBalance.class); // Replace with your next activity
                    startActivity(intent);
                    finish(); // Close the current activity
                } else {
                    Toast.makeText(ActivitySetCurrency.this, "Please select a currency", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
