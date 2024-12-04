package com.sdaproject.frugalflowapp;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityForecasting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecasting);

        // Simulating data fetch from a "database"
        int[] growthPercentages = fetchGrowthDataFromDatabase();

        // Find ProgressBar Views
        ProgressBar progressBarJanuary = findViewById(R.id.progressBarJanuary);
        ProgressBar progressBarFebruary = findViewById(R.id.progressBarFebruary);
        ProgressBar progressBarMarch = findViewById(R.id.progressBarMarch);
        ProgressBar progressBarApril = findViewById(R.id.progressBarApril);
        ProgressBar progressBarMay = findViewById(R.id.progressBarMay);
        ProgressBar progressBarJune = findViewById(R.id.progressBarJune);

        // Find TextView Views for Each Month
        TextView textJanuary = findViewById(R.id.month_january);
        TextView textFebruary = findViewById(R.id.month_february);
        TextView textMarch = findViewById(R.id.month_march);
        TextView textApril = findViewById(R.id.month_april);
        TextView textMay = findViewById(R.id.month_may);
        TextView textJune = findViewById(R.id.month_june);

        // Update Progress Bars and Text Views
        updateProgressBar(progressBarJanuary, textJanuary, growthPercentages[0], "January");
        updateProgressBar(progressBarFebruary, textFebruary, growthPercentages[1], "February");
        updateProgressBar(progressBarMarch, textMarch, growthPercentages[2], "March");
        updateProgressBar(progressBarApril, textApril, growthPercentages[3], "April");
        updateProgressBar(progressBarMay, textMay, growthPercentages[4], "May");
        updateProgressBar(progressBarJune, textJune, growthPercentages[5], "June");
    }

    /**
     * Simulates fetching growth data from a "database."
     *
     * @return An array of growth percentages for the next 6 months.
     */
    private int[] fetchGrowthDataFromDatabase() {
        // Mock database values
        return new int[]{20, 40, 60, 80, 90, 100};
    }

    /**
     * Updates the ProgressBar and TextView for a specific month.
     *
     * @param progressBar The ProgressBar to update.
     * @param textView    The TextView to update.
     * @param progress    The growth percentage to set.
     * @param monthName   The name of the month for the TextView.
     */
    private void updateProgressBar(ProgressBar progressBar, TextView textView, int progress, String monthName) {
        progressBar.setProgress(progress);
        textView.setText(String.format("%s: +%d%% Growth", monthName, progress));
    }
}