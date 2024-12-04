package com.sdaproject.frugalflowapp;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityNotifications extends AppCompatActivity {

    private TextView budgetExceededNotification;
    private TextView savingGoalMetNotification;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);  // Make sure to use the correct layout

        // Initialize Views
        budgetExceededNotification = findViewById(R.id.budget_exceeded_notification);
        savingGoalMetNotification = findViewById(R.id.saving_goal_met_notification);

        // Hardcoded Budget and Saving Goal Data
        double budgetSpent = 1200;  // Hardcoded value
        double budgetLimit = 1000;  // Hardcoded value

        double currentSavings = 5100;  // Hardcoded value
        double savingsGoal = 5000;    // Hardcoded value

        // Create BudgetNotificationService instance
        BudgetNotificationService budgetNotificationService = new BudgetNotificationService(budgetSpent, budgetLimit);

        // Check if the budget is exceeded
        if (budgetNotificationService.isBudgetExceeded()) {
            budgetExceededNotification.setVisibility(View.VISIBLE);
        } else {
            budgetExceededNotification.setVisibility(View.GONE);
        }

        // Create SavingGoalNotificationService instance
        SavingGoalNotificationService savingGoalNotificationService = new SavingGoalNotificationService(currentSavings, savingsGoal);

        // Check if the saving goal is met
        if (savingGoalNotificationService.isSavingGoalMet()) {
            savingGoalMetNotification.setVisibility(View.VISIBLE);
        } else {
            savingGoalMetNotification.setVisibility(View.GONE);
        }
    }
}

// Budget Notification Service class to handle budget-related logic
class BudgetNotificationService {

    private double budgetSpent;
    private double budgetLimit;

    public BudgetNotificationService(double budgetSpent, double budgetLimit) {
        this.budgetSpent = budgetSpent;
        this.budgetLimit = budgetLimit;
    }

    public boolean isBudgetExceeded() {
        return budgetSpent > budgetLimit;
    }
}

// Saving Goal Notification Service class to handle saving goal-related logic
class SavingGoalNotificationService {

    private double currentSavings;
    private double savingsGoal;

    public SavingGoalNotificationService(double currentSavings, double savingsGoal) {
        this.currentSavings = currentSavings;
        this.savingsGoal = savingsGoal;
    }

    public boolean isSavingGoalMet() {
        return currentSavings >= savingsGoal;
    }
}