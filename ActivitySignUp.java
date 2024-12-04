package com.sdaproject.frugalflowapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ActivitySignUp extends AppCompatActivity {

    // Declare Firebase and UI elements
    private FirebaseAuth mAuth;
    private DatabaseReference databaseReference;
    private Button signUpButton, backButton;
    private EditText firstNameEditText, lastNameEditText, emailEditText, passwordEditText, confirmPasswordEditText;
    private TextView loginRedirectTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Initialize Firebase Authentication and Realtime Database
        mAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");

        // Initialize UI elements
        signUpButton = findViewById(R.id.signup_button);
        backButton = findViewById(R.id.back_button);
        firstNameEditText = findViewById(R.id.multi_line_text_box);
        lastNameEditText = findViewById(R.id.last_name);
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        confirmPasswordEditText = findViewById(R.id.confirm_password);
        loginRedirectTextView = findViewById(R.id.login_redirect_text);

        // Set up button click listeners
        signUpButton.setOnClickListener(v -> handleSignUp());
        backButton.setOnClickListener(v -> finish());
        loginRedirectTextView.setOnClickListener(v -> {
            Intent intent = new Intent(ActivitySignUp.this, ActivitySignIn.class);
            startActivity(intent);
            finish();
        });
    }

    /**
     * Handles the sign-up logic.
     */
    private void handleSignUp() {
        // Retrieve input values
        String firstName = firstNameEditText.getText().toString().trim();
        String lastName = lastNameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString();
        String confirmPassword = confirmPasswordEditText.getText().toString();

        // Validate inputs
        if (TextUtils.isEmpty(firstName)) {
            showToast("Please enter your First Name");
            return;
        }

        if (TextUtils.isEmpty(lastName)) {
            showToast("Please enter your Last Name");
            return;
        }

        if (TextUtils.isEmpty(email) || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            showToast("Please enter a valid Email");
            return;
        }

        if (TextUtils.isEmpty(password) || password.length() < 6) {
            showToast("Password must be at least 6 characters");
            return;
        }

        if (!password.equals(confirmPassword)) {
            showToast("Passwords do not match");
            return;
        }

        // Create a new user with Firebase Authentication
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Get the Firebase User and User ID
                        FirebaseUser firebaseUser = mAuth.getCurrentUser();
                        if (firebaseUser != null) {
                            String userId = firebaseUser.getUid();

                            // Save user data to the Realtime Database
                            User user = new User(firstName, lastName, email);
                            databaseReference.child(userId).setValue(user)
                                    .addOnCompleteListener(task1 -> {
                                        if (task1.isSuccessful()) {
                                            showToast("Sign-Up Successful!");
                                            // Navigate to the Sign-In page
                                            startActivity(new Intent(ActivitySignUp.this, ActivitySignIn.class));
                                            finish();
                                        } else {
                                            showToast("Database Error: " + task1.getException().getMessage());
                                        }
                                    });
                        }
                    } else {
                        showToast("Sign-Up Failed: " + task.getException().getMessage());
                    }
                });
    }

    /**
     * Displays a toast message.
     */
    private void showToast(String message) {
        Toast.makeText(ActivitySignUp.this, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * Model class for user data.
     */
    public static class User {
        public String firstName, lastName, email;

        public User() {
            // Default constructor required for calls to DataSnapshot.getValue(User.class)
        }

        public User(String firstName, String lastName, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        }
    }
}