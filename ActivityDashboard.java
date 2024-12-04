package com.sdaproject.frugalflowapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ActivityDashboard extends AppCompatActivity {

    private FirebaseDatabase mDatabase;
    private DatabaseReference mRef;

    private TextView cashBalanceAmount;
    private ImageButton addTransactionButton;
    private ImageView notificationButton;
    private TextView homeNav, settingsNav, planningNav, forecastingNav, networthNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Initialize Firebase
        mDatabase = FirebaseDatabase.getInstance();
        mRef = mDatabase.getReference("cashBalance");

        // Initialize UI elements
        cashBalanceAmount = findViewById(R.id.cash_balance_amount);
        addTransactionButton = findViewById(R.id.add_transaction_button);
        notificationButton = findViewById(R.id.notification_button); // Notification bell button

        // Bottom Navigation elements
        homeNav = findViewById(R.id.nav_home);
        settingsNav = findViewById(R.id.nav_settings);
        planningNav = findViewById(R.id.nav_planning);
        forecastingNav = findViewById(R.id.nav_forecasting);
        networthNav = findViewById(R.id.nav_networth);

        // Set initial cash balance
        setCashBalance("1000.00");

        // Notification Button Logic
        notificationButton.setOnClickListener(v -> navigateToActivity(ActivityNotifications.class));

        // Add Transaction Button Logic
        addTransactionButton.setOnClickListener(v -> navigateToActivity(AddTransactionActivity.class));

        // Bottom Navigation Logic
        homeNav.setOnClickListener(v -> navigateToActivity(ActivityDashboard.class));
        settingsNav.setOnClickListener(v -> navigateToActivity(ActivitySettings.class));
        planningNav.setOnClickListener(v -> navigateToActivity(ActivityPlanning.class));
        forecastingNav.setOnClickListener(v -> navigateToActivity(ActivityForecasting.class));
        networthNav.setOnClickListener(v -> navigateToActivity(ActivityNetWorthCalculation.class));
    }

    // SRP - This method only handles the task of setting the cash balance UI
    private void setCashBalance(String amount) {
        // Display the cash balance amount on the dashboard
        cashBalanceAmount.setText(amount);
    }

    // OCP - The navigateToActivity method allows easy extension for navigation without modifying existing logic
    private void navigateToActivity(Class<?> targetActivity) {
        // General navigation function to avoid redundancy
        Intent intent = new Intent(ActivityDashboard.this, targetActivity);
        startActivity(intent);
    }
}