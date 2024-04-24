package com.example.happyuapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Notification extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        // Récupérer les données supplémentaires de l'Intent
        String notificationTitle = getIntent().getStringExtra("notification_title");
        String notificationContent = getIntent().getStringExtra("notification_content");

        // Afficher la notification dans votre activité
        TextView textViewTitle = findViewById(R.id.textViewTitle);
        TextView textViewContent = findViewById(R.id.textViewContent);
        textViewTitle.setText(notificationTitle);
        textViewContent.setText(notificationContent);
    }
}