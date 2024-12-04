package com.sdaproject.frugalflowapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class ActivitySettings extends AppCompatActivity {

    private Switch darkModeSwitch;
    private Button notificationsButton, categoriesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Initialize the Dark Mode switch
        darkModeSwitch = findViewById(R.id.dark_mode_switch);

        // Initialize the buttons
        notificationsButton = findViewById(R.id.notifications_button);
        categoriesButton = findViewById(R.id.categories_button);

        // Check the current theme and set the switch state accordingly
        int currentMode = getResources().getConfiguration().uiMode & android.content.res.Configuration.UI_MODE_NIGHT_MASK;
        darkModeSwitch.setChecked(currentMode == android.content.res.Configuration.UI_MODE_NIGHT_YES);

        // Listen for Dark Mode toggle changes
        darkModeSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
        });

        // Set up click listeners for Notifications and Categories buttons
        notificationsButton.setOnClickListener(v -> {
            Intent intent = new Intent(ActivitySettings.this, ActivityNotifications.class);
            startActivity(intent);
        });

        categoriesButton.setOnClickListener(v -> {
            Intent intent = new Intent(ActivitySettings.this, CategoriesActivity.class);
            startActivity(intent);
        });
    }
}