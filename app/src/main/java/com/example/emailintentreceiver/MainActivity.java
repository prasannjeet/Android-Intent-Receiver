package com.example.emailintentreceiver;

import static java.util.Arrays.*;
import static java.util.Collections.*;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.emailintentreceiver.databinding.ActivityMainBinding;

import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent incomingIntent = getIntent();
        String email = "NO DATA RECEIVED";
        String subject = "NO DATA RECEIVED";
        String emailText = "NO DATA RECEIVED";
        if (incomingIntent.getAction().contains("SENDTO")) {
            Object[] tempArray = (Object[]) incomingIntent.getExtras().get(Intent.EXTRA_EMAIL);
            email = (String) tempArray[0];
            subject = (String) incomingIntent.getExtras().get(Intent.EXTRA_SUBJECT);
            emailText = (String) incomingIntent.getExtras().get(Intent.EXTRA_TEXT);
        }
        TextView emailTextBox = findViewById(R.id.email_text_box);
        TextView subjectTextBox = findViewById(R.id.subject_text_box);
        TextView messageTextBox = findViewById(R.id.message_text_box);
        emailTextBox.setText(email);
        subjectTextBox.setText(subject);
        messageTextBox.setText(emailText);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();
        Button sendButton = binding.actionButton;
        sendButton.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Any intended action can be performed here", Toast.LENGTH_SHORT).show();
        });

    }

}