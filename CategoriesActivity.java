package com.sdaproject.frugalflowapp;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class CategoriesActivity extends AppCompatActivity {
    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;
    private List<Category> categoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        // Initialize RecyclerView
        categoryRecyclerView = findViewById(R.id.category_recycler_view);
        categoryRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Prepare category data
        categoryList = prepareCategoryData();

        // Create and set adapter
        categoryAdapter = new CategoryAdapter(categoryList, new CategoryAdapter.OnCategorySelectListener() {
            @Override
            public void onCategorySelected(Category category) {
                // Handle category selection
                Toast.makeText(CategoriesActivity.this,
                        "Selected Category: " + category.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });
        categoryRecyclerView.setAdapter(categoryAdapter);
    }

    private List<Category> prepareCategoryData() {
        List<Category> categories = new ArrayList<>();

        // Food Category
        List<Product> foodProducts = new ArrayList<>();
        foodProducts.add(new Product("Pizza", 10.99, "Cheesy Margherita Pizza", "pizza_image"));
        foodProducts.add(new Product("Burger", 8.50, "Classic Cheeseburger", "burger_image"));
        foodProducts.add(new Product("Pasta", 12.99, "Creamy Alfredo Pasta", "pasta_image"));
        Category foodCategory = new Category("Food", "🍔", "Delicious meals and snacks", foodProducts);

        // Electronics Category
        List<Product> electronicsProducts = new ArrayList<>();
        electronicsProducts.add(new Product("Smartphone", 599.99, "Latest Model Smartphone", "smartphone_image"));
        electronicsProducts.add(new Product("Laptop", 1099.99, "High Performance Laptop", "laptop_image"));
        electronicsProducts.add(new Product("Headphones", 199.99, "Noise Cancelling Headphones", "headphones_image"));
        Category electronicsCategory = new Category("Electronics", "💻", "Gadgets and devices", electronicsProducts);

        // Toys Category
        List<Product> toysProducts = new ArrayList<>();
        toysProducts.add(new Product("Teddy Bear", 29.99, "Soft Cuddly Teddy", "teddy_image"));
        toysProducts.add(new Product("LEGO Set", 49.99, "Creative Building Blocks", "lego_image"));
        toysProducts.add(new Product("Board Game", 34.50, "Family Fun Board Game", "board_game_image"));
        Category toysCategory = new Category("Toys", "🧸", "Fun and games for kids", toysProducts);

        // Clothing Category
        List<Product> clothingProducts = new ArrayList<>();
        clothingProducts.add(new Product("T-Shirt", 19.99, "Comfortable Cotton Tee", "tshirt_image"));
        clothingProducts.add(new Product("Jeans", 59.99, "Classic Denim Jeans", "jeans_image"));
        clothingProducts.add(new Product("Jacket", 89.99, "Stylish Winter Jacket", "jacket_image"));
        Category clothingCategory = new Category("Clothing", "👗", "Stylish wear and accessories", clothingProducts);

        // Stationery Category
        List<Product> stationeryProducts = new ArrayList<>();
        stationeryProducts.add(new Product("Notebook", 5.99, "Lined Paper Notebook", "notebook_image"));
        stationeryProducts.add(new Product("Pen Set", 12.50, "Smooth Writing Pen Set", "pen_set_image"));
        stationeryProducts.add(new Product("Pencil Case", 9.99, "Large Capacity Pencil Case", "pencil_case_image"));
        Category stationeryCategory = new Category("Stationery", "✏", "Pens, notebooks, and supplies", stationeryProducts);

        // Miscellaneous Category
        List<Product> miscProducts = new ArrayList<>();
        miscProducts.add(new Product("Water Bottle", 15.99, "Insulated Reusable Bottle", "water_bottle_image"));
        miscProducts.add(new Product("Backpack", 49.99, "Durable Travel Backpack", "backpack_image"));
        miscProducts.add(new Product("Umbrella", 24.50, "Compact Folding Umbrella", "umbrella_image"));
        Category miscCategory = new Category("Miscellaneous", "📦", "Various items and supplies", miscProducts);

        categories.add(foodCategory);
        categories.add(electronicsCategory);
        categories.add(toysCategory);
        categories.add(clothingCategory);
        categories.add(stationeryCategory);
        categories.add(miscCategory);

        return categories;
    }
}