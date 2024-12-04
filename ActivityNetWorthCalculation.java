package com.sdaproject.frugalflowapp;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityNetWorthCalculation extends AppCompatActivity {

    // Declare Views
    private TextView expenseTextView, incomeTextView, expenseAmtTextView, incomeAmtTextView, netWorthTextView;
    private TextView categoryFoodDrinks, categoryShopping, categoryMedical, categoryTransportation, categoryDebts;
    private TextView categoryUtilityBills, categoryRent, categoryEducation, categorySubscription, categoryExcursions, categoryOthers;
    private ProgressBar progressBarFoodDrinks, progressBarShopping, progressBarMedical, progressBarTransportation;
    private ProgressBar progressBarDebts, progressBarUtilityBills, progressBarRent, progressBarEducation;
    private ProgressBar progressBarSubscription, progressBarExcursions, progressBarOthers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_worth_calculation); // Set the XML layout file

        // Initialize Views using findViewById
        expenseTextView = findViewById(R.id.expenseTextView);
        incomeTextView = findViewById(R.id.incomeTextView);
        expenseAmtTextView = findViewById(R.id.expenseAmtTextView);
        incomeAmtTextView = findViewById(R.id.incomeAmtTextView);
        netWorthTextView = findViewById(R.id.netWorthTextView);

        categoryFoodDrinks = findViewById(R.id.category_food_drinks);
        categoryShopping = findViewById(R.id.category_shopping);
        categoryMedical = findViewById(R.id.category_medical);
        categoryTransportation = findViewById(R.id.category_transportation);
        categoryDebts = findViewById(R.id.category_debts);
        categoryUtilityBills = findViewById(R.id.category_utility_bills);
        categoryRent = findViewById(R.id.category_rent);
        categoryEducation = findViewById(R.id.category_education);
        categorySubscription = findViewById(R.id.category_subscription);
        categoryExcursions = findViewById(R.id.category_excursions);
        categoryOthers = findViewById(R.id.category_others);

        // Initialize ProgressBars
        progressBarFoodDrinks = findViewById(R.id.progressBarFoodDrinks);
        progressBarShopping = findViewById(R.id.progressBarShopping);
        progressBarMedical = findViewById(R.id.progressBarMedical);
        progressBarTransportation = findViewById(R.id.progressBarTransportation);
        progressBarDebts = findViewById(R.id.progressBarDebts);
        progressBarUtilityBills = findViewById(R.id.progressBarUtilityBills);
        progressBarRent = findViewById(R.id.progressBarRent);
        progressBarEducation = findViewById(R.id.progressBarEducation);
        progressBarSubscription = findViewById(R.id.progressBarSubscription);
        progressBarExcursions = findViewById(R.id.progressBarExcursions);
        progressBarOthers = findViewById(R.id.progressBarOthers);

        // Set values to the TextViews
        expenseTextView.setText("EXPENSE");
        incomeTextView.setText("INCOME");

        expenseAmtTextView.setText("$0");
        incomeAmtTextView.setText("$50,000");

        netWorthTextView.setText("Net Worth: $0");

        categoryFoodDrinks.setText("Food & Drinks");
        categoryShopping.setText("Shopping");
        categoryMedical.setText("Medical");
        categoryTransportation.setText("Transportation");
        categoryDebts.setText("Debts");
        categoryUtilityBills.setText("Utility Bills");
        categoryRent.setText("Rent");
        categoryEducation.setText("Education");
        categorySubscription.setText("Subscription");
        categoryExcursions.setText("Excursions");
        categoryOthers.setText("Others");

        // Animate the progress bars (smooth animation for each progress change)
        animateProgressBar(progressBarFoodDrinks, 20); // Example progress
        animateProgressBar(progressBarShopping, 40);
        animateProgressBar(progressBarMedical, 30);
        animateProgressBar(progressBarTransportation, 50);
        animateProgressBar(progressBarDebts, 70);
        animateProgressBar(progressBarUtilityBills, 60);
        animateProgressBar(progressBarRent, 80);
        animateProgressBar(progressBarEducation, 90);
        animateProgressBar(progressBarSubscription, 55);
        animateProgressBar(progressBarExcursions, 85);
        animateProgressBar(progressBarOthers, 45);
    }

    /**
     * Animate the progress of a ProgressBar.
     * @param progressBar The ProgressBar to animate.
     * @param progress The target progress value.
     */
    private void animateProgressBar(ProgressBar progressBar, int progress) {
        // Create an ObjectAnimator for the progress bar's progress property
        ObjectAnimator progressAnimator = ObjectAnimator.ofInt(progressBar, "progress", 0, progress);
        progressAnimator.setDuration(1000); // Duration in milliseconds (1 second)
        progressAnimator.start();
    }
}
