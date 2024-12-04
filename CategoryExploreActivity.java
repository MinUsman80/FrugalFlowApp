package com.sdaproject.frugalflowapp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

public class CategoryExploreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        setupCategoryCardListeners();
    }

    private void setupCategoryCardListeners() {
        MaterialCardView foodCard = findViewById(R.id.food_card);
        MaterialCardView toysCard = findViewById(R.id.toys_card);
        MaterialCardView electronicsCard = findViewById(R.id.electronics_card);
        MaterialCardView clothingCard = findViewById(R.id.clothing_card);
        MaterialCardView stationeryCard = findViewById(R.id.stationery_card);
        MaterialCardView miscCard = findViewById(R.id.misc_card);

        foodCard.setOnClickListener(v -> handleCategoryClick("Food"));
        toysCard.setOnClickListener(v -> handleCategoryClick("Toys"));
        electronicsCard.setOnClickListener(v -> handleCategoryClick("Electronics"));
        clothingCard.setOnClickListener(v -> handleCategoryClick("Clothing"));
        stationeryCard.setOnClickListener(v -> handleCategoryClick("Stationery"));
        miscCard.setOnClickListener(v -> handleCategoryClick("Miscellaneous"));
    }

    private void handleCategoryClick(String category) {
        Toast.makeText(this, category + " selected", Toast.LENGTH_SHORT).show();
    }
}