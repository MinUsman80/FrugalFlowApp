package com.sdaproject.frugalflowapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class ActivitySignIn extends AppCompatActivity {

    // Declare Firebase and UI elements
    private FirebaseAuth mAuth;
    private EditText emailEditText, passwordEditText;
    private Button signInButton, backButton;
    private TextView signUpRedirectText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        // Initialize Firebase Authentication
        mAuth = FirebaseAuth.getInstance();

        // Initialize UI elements
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        signInButton = findViewById(R.id.signin_button); // Represents "Sign In" button
        backButton = findViewById(R.id.back_button);
        signUpRedirectText = findViewById(R.id.signup_redirect_text);

        // Set up button click listeners
        signInButton.setOnClickListener(v -> handleSignIn());
        backButton.setOnClickListener(v -> finish());
        signUpRedirectText.setOnClickListener(v -> {
            Intent intent = new Intent(ActivitySignIn.this, ActivitySignUp.class);
            startActivity(intent);
        });
    }

    /**
     * Handles the sign-in logic.
     */
    private void handleSignIn() {
        // Retrieve input values
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString();

        // Validate inputs
        if (TextUtils.isEmpty(email)) {
            showToast("Please enter your Email");
            return;
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            showToast("Please enter a valid Email");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            showToast("Please enter your Password");
            return;
        }

        // Authenticate the user with Firebase Authentication
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        showToast("Sign-In Successful!");
                        // Navigate to the next activity (e.g., Dashboard)
                        Intent intent = new Intent(ActivitySignIn.this, ActivityDashboard.class); // Replace with your dashboard activity
                        startActivity(intent);
                        finish();
                    } else {
                        showToast("Sign-In Failed: " + task.getException().getMessage());
                    }
                });
    }

    /**
     * Displays a toast message.
     */
    private void showToast(String message) {
        Toast.makeText(ActivitySignIn.this, message, Toast.LENGTH_SHORT).show();
    }
}
