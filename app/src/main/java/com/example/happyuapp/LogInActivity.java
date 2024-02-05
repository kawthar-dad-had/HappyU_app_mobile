package com.example.happyuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LogInActivity extends AppCompatActivity {

    TextView logInTxt, welcomeBackTxt;
    EditText emailEditText, passwordEditText;
    Button logInButton, forgotPasswordBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        // declaring the views
        logInTxt = findViewById(R.id.logInTxt);
        welcomeBackTxt = findViewById(R.id.welcomeBackTxt);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        logInButton = findViewById(R.id.logInButton);
        forgotPasswordBtn = findViewById(R.id.forgotPasswordBtn);




    }
}