package com.sdaproject.frugalflowapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sdaproject.frugalflowapp.R;
import com.sdaproject.frugalflowapp.Expense;
import com.sdaproject.frugalflowapp.ExpenseCategory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ExpenseViewModel extends ViewModel {
    private MutableLiveData<Double> totalMonthlyExpenses = new MutableLiveData<>(0.0);
    private MutableLiveData<Double> expenseGrowthRate = new MutableLiveData<>(7.2);
    private MutableLiveData<List<ExpenseCategory>> expenseCategories = new MutableLiveData<>();
    private MutableLiveData<List<Expense>> expenses = new MutableLiveData<>();

    public LiveData<Double> getTotalMonthlyExpenses() {
        return totalMonthlyExpenses;
    }

    public LiveData<Double> getExpenseGrowthRate() {
        return expenseGrowthRate;
    }

    public LiveData<List<ExpenseCategory>> getExpenseCategories() {
        return expenseCategories;
    }

    public LiveData<List<Expense>> getExpenses() {
        return expenses;
    }

    public ExpenseViewModel() {
        loadCategories();
        loadExpenses();
        calculateTotalExpenses();
    }

    private void loadCategories() {
        List<ExpenseCategory> categories = new ArrayList<>();
        categories.add(new ExpenseCategory("Food", R.drawable.ic_food, "#FF6B6B"));
        categories.add(new ExpenseCategory("Transport", R.drawable.ic_transport, "#4ECDC4"));
        categories.add(new ExpenseCategory("Entertainment", R.drawable.ic_entertainment, "#45B7D1"));
        categories.add(new ExpenseCategory("Utilities", R.drawable.ic_utilities, "#F9D56E"));
        expenseCategories.setValue(categories);
    }

    private void loadExpenses() {
        List<ExpenseCategory> categories = expenseCategories.getValue();
        if (categories == null || categories.isEmpty()) return;

        List<Expense> expenseList = new ArrayList<>();
        // Format the date as a string
        String currentDate = getCurrentDateString();

        // Corrected constructor calls with parameters in the correct order
        expenseList.add(new Expense("Groceries", 250.0, categories.get(0), currentDate));
        expenseList.add(new Expense("Uber rides", 100.0, categories.get(1), currentDate));

        expenses.setValue(expenseList);
        calculateTotalExpenses();
    }

    private String getCurrentDateString() {
        // You can format the date as needed. Here's an example format.
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return sdf.format(new Date());
    }

    private void calculateTotalExpenses() {
        List<Expense> expenseList = expenses.getValue();
        double total = 0.0;

        if (expenseList != null) {
            for (Expense expense : expenseList) {
                total += expense.getTotalAmount();
            }
        }

        totalMonthlyExpenses.setValue(total);
    }

    public void addExpense(Expense expense) {
        List<Expense> currentExpenses = expenses.getValue();
        if (currentExpenses == null) {
            currentExpenses = new ArrayList<>();
        }
        currentExpenses.add(expense);
        expenses.setValue(currentExpenses);
        calculateTotalExpenses();
    }
}