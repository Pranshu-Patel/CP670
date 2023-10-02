package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    public void clickHandler(View view) {
        // Get the email and password EditText views
        EditText emailEditText = findViewById(R.id.login_email);
        EditText passwordEditText = findViewById(R.id.login_password);

        // Get the email and password strings
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        // Validate the email and password
        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            // Show an error message for invalid email
            Toast.makeText(this, "Invalid email address", Toast.LENGTH_SHORT).show();
        }
        else if (password.isEmpty()) {
            // Show an error message for empty password
            Toast.makeText(this, "Password cannot be empty", Toast.LENGTH_SHORT).show();
        }
        else {
            saveData();

            Toast.makeText(LoginActivity.this,"Welcome!",Toast.LENGTH_SHORT).show();

            // Call startActivity() with your assignment 1 MainActivity as the next Activity to start
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);

        }
    }

    private void loadData() {
        EditText emailEditText = findViewById(R.id.login_email);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String defaultEmail = sharedPreferences.getString("DefaultEmail", "email@domain.com");
        emailEditText.setText(defaultEmail);
    }

    public void saveData() {
        EditText emailEditText = findViewById(R.id.login_email);

        // Store the text in the login email field to the SharedPreferences of your application
        SharedPreferences.Editor editor = getSharedPreferences("MyPrefs", MODE_PRIVATE).edit();
        editor.putString("DefaultEmail", emailEditText.getText().toString());
        editor.apply();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Assignment 2 CP670");
        setContentView(R.layout.activity_login);

        loadData();
        Log.i(logText,"onCreate() encountered.");

        Button loginButton = findViewById(R.id.login_button);
        EditText loginEmail = findViewById(R.id.login_email);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String email = sharedPreferences.getString("DefaultEmail", "email@domain.com");

        // Set the initial text of the login email field
        loginEmail.setText(email);

    }
    String logText = "LoginActivity :";
    @Override
    protected void onStart() {
        super.onStart();
        // Connect to database or other services here
        Log.i(logText,"onStart() encountered.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Update UI elements or data here
        Log.i(logText,"onResume() encountered.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Save data or stop animations here
        Log.i(logText, "onPause() encountered.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        // Disconnect from database or other services here
        Log.i(logText,"onStop() encountered.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Release resources or perform cleanup tasks here
        Log.i(logText,"onDestroy() encountered.");
    }

    protected void onSavedInstanceState(){}

    protected void onRestoreInstanceState(){}




}