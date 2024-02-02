package com.example.laboratoryactivityweek8_9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void verifyAge (View v){
        EditText ageInput = findViewById(R.id.editAge);

        if (ageInput.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please enter your age.", Toast.LENGTH_SHORT).show();
            return;
        }

        int age = Integer.parseInt(ageInput.getText().toString());

        if (age >= 18) {
            // User is eligible to vote, move to Vote Activity
            Toast.makeText(this, "You are eligible to vote.", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, VoteActivity.class);
            startActivity(i);
        } else {
            // User is not eligible to vote, cannot move to Vote Activity
            Toast.makeText(this, "You are not eligible to vote.", Toast.LENGTH_SHORT).show();
        }
    }
}