package com.sdaproject.frugalflowapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class ActivitySetCashBalance extends AppCompatActivity {

    private EditText cashBalanceInput;
    private Button finishSetupButton;

    // Firebase Database reference
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_cash_balance); // Update with your actual layout file name

        // Initialize Firebase Database reference
        databaseReference = FirebaseDatabase.getInstance().getReference("Users"); // Root node for storing user data

        // Initialize UI elements
        cashBalanceInput = findViewById(R.id.cash_balance_input);
        finishSetupButton = findViewById(R.id.save_currency_button);

        // Set up button click listener
        finishSetupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the entered balance
                String balanceText = cashBalanceInput.getText().toString();

                if (!balanceText.isEmpty()) {
                    try {
                        // Validate that the entered balance is numeric and positive
                        double balance = Double.parseDouble(balanceText);
                        if (balance < 0) {
                            throw new NumberFormatException("Negative balance");
                        }

                        // Save the balance to Firebase
                        saveBalanceToFirebase(balance);

                        // Provide feedback to the user
                        Toast.makeText(ActivitySetCashBalance.this,
                                "Cash balance set to: $" + balance,
                                Toast.LENGTH_SHORT).show();

                        // Navigate to the next screen or finish the setup
                        Intent intent = new Intent(ActivitySetCashBalance.this, ActivityDashboard.class); // Replace with your main activity
                        startActivity(intent);
                        finish();
                    } catch (NumberFormatException e) {
                        // Handle invalid input
                        Toast.makeText(ActivitySetCashBalance.this,
                                "Please enter a valid positive number!",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ActivitySetCashBalance.this,
                            "Please enter a valid balance!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * Saves the cash balance to Firebase Realtime Database.
     *
     * @param balance The cash balance to save.
     */
    private void saveBalanceToFirebase(double balance) {
        // Assume the user is authenticated, and you have their user ID
        String userId = "exampleUserId"; // Replace with actual user ID from FirebaseAuth if authentication is enabled

        // Create a reference to the user's node in Firebase
        DatabaseReference userRef = databaseReference.child(userId);

        // Store the balance under the user's node
        userRef.child("cash_balance").setValue(balance)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(ActivitySetCashBalance.this,
                                "Balance successfully saved to Firebase!",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(ActivitySetCashBalance.this,
                                "Failed to save balance: " + Objects.requireNonNull(task.getException()).getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
